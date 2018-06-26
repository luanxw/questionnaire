package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
	/*
	 * 查找所有
	 */
	List<Options> findAllOptions() throws Exception;
	
	/*
	 *根据ID查询 
	 */
	Options findById(long id) throws Exception;

	/*
	 * 根据关键字查询
	 */
	List<Options> query(String keywords) throws Exception;
	
	/*
	 * 保存或更新
	 */
	void saveOrUpdate(Options options) throws Exception;
	
	/*
	 * 根据ID删除
	 */
	int deleteById(long id) throws Exception;
	
	/*
	 * 批量删除
	 */
	void batchDelete(Long[] ids)throws Exception;

}
