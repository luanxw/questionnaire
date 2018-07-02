package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {

	List<QuestionnaireVM> findAll() throws Exception;

	Questionnaire findById(long id) throws Exception;

	List<Questionnaire> query(String keywords) throws Exception;

	void saveOrUpdate(Questionnaire questionnaire, long[] questionId) throws Exception;

	void deleteById(long id) throws Exception;

	void batchDelete(List<Long> ids) throws Exception;

	QuestionnaireVM findQuestionnaireById(long id) throws Exception;

}
