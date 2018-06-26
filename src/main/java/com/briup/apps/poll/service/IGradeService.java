package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;



public interface IGradeService {
	/*
	 * 查询班级所有信息
	 */
	List<Grade> findAll() throws Exception;
	/*
	 * 通过id查询
	 */
	Grade findById(long id) throws Exception;
	/*
	 * 通过关键字查询
	 */
	List<Grade> query(String keywords) throws Exception;
	/*
	 * 保存或者更新班级信息
	 */
	void saveOrUpdate(Grade grade) throws Exception;
	/*
	 * 通过ID删除班级信息
	 */
	void deleteById(long id) throws Exception;
	/*
	 * 批量删除
	 */
	void batchDelete(Long[] ids)throws Exception;
}
