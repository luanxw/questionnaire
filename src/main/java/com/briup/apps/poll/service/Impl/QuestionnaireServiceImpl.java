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
	public List<Questionnaire> findAll() throws Exception {
		QuestionnaireExample  example= new QuestionnaireExample();
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public QuestionnaireVM findVMById(long id) throws Exception {
		
		return questionnaireVMMapper.selectById(id);
	}

	@Override
	public List<Questionnaire> query(String keywords) throws Exception {
		QuestionnaireExample  example= new QuestionnaireExample();
		example.createCriteria().andNameLike(keywords);
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Questionnaire questionnaire,long[] questionIds) throws Exception {
		//1.判断保存或者更新
		if (questionnaire.getId()==null) {
			//1.1保存
			//1.1.1保存问卷信息
			questionnaireMapper.insert(questionnaire);
			long questionnaireId = questionnaire.getId();
			//维护问卷与问题关系
			for (long questionId : questionIds) {
				Qq qq = new Qq();
				qq.setQuestionId(questionId);
				qq.setQuestionnaireId(questionnaireId);
				qqMapper.insert(qq);
			}
			
		} else {
			//1.1修改
			//1.2.1修改问卷信息
			questionnaireMapper.updateByPrimaryKey(questionnaire);
			long questionnaireId = questionnaire.getId();
			   //1.2.2删除问卷下所有问卷问题关系
			//delete from ploo_qq where questionnaire_id = #{id}
				QqExample example = new QqExample();
				example.createCriteria().andQuestionnaireIdEqualTo(questionnaireId);
		        qqMapper.deleteByExample(example);
		        //1.2.3保存新的问卷问题关系
				//1.1.2维护问卷问题的关系qq
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
}
