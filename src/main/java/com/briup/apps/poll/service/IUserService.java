package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;

public interface IUserService {
 //查询所有用户
	List<User> findAll() throws Exception;
	//通过ID查询所有用户
	User findById(long id) throws Exception;
	//通过关键字查询
	List<User> query(String keyword) throws Exception;
	//添加或更新
	void saveOrupdate(User user) throws Exception;
	//通过ID删除
	void deleteById(long id) throws Exception;
	//批量删除
	void batchdelete(Long[] ids) throws Exception; 
}
