package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
	
	/*
	 * 查找所有
	 */
	List<Survey> findAllSurvey() throws Exception;
	
	/**
	 * 根据ID进行精确查询
	 * */
	SurveyVM findById(long id) throws Exception;
	
	/*
	 * 根据关键字查询
	 */
	List<Survey> query(String keywords) throws Exception;
	
	/*
	 * 保存或更新
	 */
	void saveOrUpdate(Survey survey) throws Exception;
	
	/*
	 * 根据ID删除
	 */
	int deleteById(long id) throws Exception;
	
	/*
	 * 批量删除
	 */
	void batchDelete(Long[] ids)throws Exception;
	
	/*
	 * 精准查询
	 */
	List<SurveyVM> findAllSurveyVM() throws Exception;
	
	
	
	

}
