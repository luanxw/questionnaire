package com.briup.apps.poll.service;

import java.util.List;


import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {

	List<Questionnaire>findAll() throws Exception;
	//Questionnaire findById(long id) throws Exception;
	List<Questionnaire>query(String keywords)throws Exception;
	void saveOrUpdate(Questionnaire questionnaire,long[] questionIds)throws Exception;
	void deleteById(long id) throws Exception;
	void batchDelete(List<Long>ids)throws Exception;
	
	//List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception;
	//void saveOrUpdateQuestionnaireVM(QuestionnaireVM questionnaireVM) throws Exception;
	QuestionnaireVM findVMById(long id) throws Exception;
	
}
