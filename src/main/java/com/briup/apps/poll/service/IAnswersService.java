package com.briup.apps.poll.service;
/**
*          @author
*          @version
*          @describe
*/

import java.util.List;
import com.briup.apps.poll.bean.answers;

public interface IAnswersService {
	
	List<answers> findAll() throws Exception;
	
	answers findById(Long id) throws Exception;
	
	List<answers> query(String keywords) throws Exception;
	
	void deleteById(Long id) throws Exception;
	
	void saveOrUpdate(answers answers) throws Exception;
	
	void batchDelete(Long[] ids) throws Exception;

}
