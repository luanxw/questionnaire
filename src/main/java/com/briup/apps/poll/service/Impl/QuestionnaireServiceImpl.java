package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.QqExample;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QqMapper;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {

	@Autowired
	private QuestionnaireMapper questionnaireMapper;

	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;

	@Autowired
	private QqMapper qqMapper;

	@Override
	public List<QuestionnaireVM> findAll() throws Exception {
		return questionnaireVMMapper.queryQuestionnaire();
	}

	@Override
	public Questionnaire findById(long id) throws Exception {

		return questionnaireMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Questionnaire> query(String keywords) throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		example.createCriteria().andNameLike(keywords);
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Questionnaire questionnaire, long[] questionIds) throws Exception {

		if (questionnaire.getId() == null) {
			// 保存操作
			// 保存调查问卷
			questionnaireMapper.insert(questionnaire);
			// 保存调查问卷关系
			long questionnaireId = questionnaire.getId();
			for (long questionId : questionIds) {
				Qq qq = new Qq();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
		} else {
			questionnaireMapper.updateByPrimaryKeyWithBLOBs(questionnaire);
			long questionnaireId = questionnaire.getId();
			QqExample example = new QqExample();
			example.createCriteria().andQuestionnaireIdEqualTo(questionnaireId);
			qqMapper.deleteByExample(example);
			for (long questionId : questionIds) {
				Qq qq = new Qq();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
		}

	}

	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for (Long id : ids) {
			questionnaireMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public QuestionnaireVM findQuestionnaireById(long id) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireVMMapper.selectById(id);
	}

}
