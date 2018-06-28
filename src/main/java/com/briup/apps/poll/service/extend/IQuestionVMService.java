package com.briup.apps.poll.service.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionVM;
//import com.briup.apps.poll.web.controller.extend.saveOrUpdateQuestionVM;

public interface IQuestionVMService {



	//saveOrUpdateQuestionVM saveOrUpdateQuestionVM = null;
	void deleteById(long id) throws Exception;
	

	List<QuestionVM> findAllQuestionVM()throws Exception;

	void saveOrUpdateQuestionVM(QuestionVM questionVM) throws Exception;

}
