package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	
		List<SurveyVM> findByClazzIdAndCheckPass(long id) throws Exception;
		
		void saveOrUpdate(Survey survey) throws Exception;
		
		List<SurveyVM> findAll() throws Exception;
		
		SurveyVM findById(long id) throws Exception;
		
		Survey findSurveyById(long id) throws Exception;
		
		void deleteById(long id) throws Exception;
		
		void batchDelete(long[] ids) throws Exception;
	


}
