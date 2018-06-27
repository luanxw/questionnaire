package com.briup.apps.poll.service;

import java.util.List;
import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.extend.QqVM;



public interface IQqService {

	List<Qq> findAll() throws Exception;	
	Qq findById(long id) throws Exception;
	void saveOrUpdate(Qq qq) throws Exception;
	void deleteById(long id) throws Exception;
	void batchDelete(Long[] ids)throws Exception;
	
	//扩展方法
	// List<QqVM> selectAll() throws Exception;
	 //List<QqVM> selectById(Long id) throws Exception;
	// void deleteById(Long id) throws Exception;
	// void saveOrUpdate(QqVM qqvm) throws Exception;
	 //void batchdelete(Long[] id) throws Exception;
	List<QqVM> selectAllQqVM() throws Exception;

}
