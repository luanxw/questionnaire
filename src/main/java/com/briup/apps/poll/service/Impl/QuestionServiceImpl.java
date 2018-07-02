package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private OptionsMapper optionsMapper;

	@Override
	public List<Question> findAll() throws Exception {
		// TODO Auto-generated method stub
		QuestionExample example = new QuestionExample();

		return questionMapper.selectByExample(example);
	}

	@Override
	public Question findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Question> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		QuestionExample example = new QuestionExample();
		// 添加了
		example.createCriteria().andNameLike(keywords);
		return questionMapper.selectByExample(example);
	}

	@Override
	public void saveOrUpdate(Question question) throws Exception {
		// TODO Auto-generated method stub
		if (question.getId() != null) {
			// 更新
			questionMapper.updateByPrimaryKey(question);
		} else {
			// 插入
			questionMapper.insert(question);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(Long[] ids) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdateQuestion(QuestionVM questionVM) throws Exception {
		// TODO Auto-generated method stub
		List<Options> options = questionVM.getOptions();
		Question question = new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());

		if (question.getId() == null) {
			if (question.getQuestiontype().equals("简答题")) {
				questionMapper.insert(question);
			} else {
				// 2.1.2 保存单选和多选题的时候需要先保存题目信息，再保存选项信息
				questionMapper.insert(question);
				// 如何获取刚刚插入到问题的ID
				long questionId = question.getId();
				for (Options option : options) {
					// 为每个option设置question_id
					option.setQuestionId(questionId);
					// 保存选项
					optionsMapper.insert(option);
				}
			}

		} else {
			//2.2修改
			//2.2.1修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//2.2.2修改选项信息（添加新选项，删除旧选项，对原来选项修改）
			//1. 删除该题目原有的选项
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());
			optionsMapper.deleteByExample(example);
			//2.重新添加选项
			long questionId=question.getId();
			for(Options option:options){
				option.setQuestionId(questionId);
				optionsMapper.insert(option);
			}
		}
	}

}
