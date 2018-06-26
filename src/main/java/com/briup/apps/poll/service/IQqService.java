package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Qq;


public interface IQqService {

	List<Qq> findAll() throws Exception;	
	Qq findById(long id) throws Exception;
	void saveOrUpdate(Qq qq) throws Exception;
	void deleteById(long id) throws Exception;
	void batchDelete(Long[] ids)throws Exception;
}
