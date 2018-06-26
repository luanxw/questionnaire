package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

public interface ISchoolService {
	//全部查询学校的信息
	List<School> findAll() throws Exception;
	//根据id值查询学校信息
	School findById(long id) throws Exception;
	//根据关键词查询学校信息
	List<School> query(String keywords) throws Exception;
	//插入或者更新一条学校记录
	void saveOrUpdate(School school) throws Exception;
	//根据id值删除一条学校记录
	void deleteById(long id) throws Exception;
	//批量删除学校记录
	void batchDelete(Long[] ids)throws Exception;
}
