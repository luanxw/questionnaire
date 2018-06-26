package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.dao.SchoolMapper;
import com.briup.apps.poll.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService {
@Autowired
private SchoolMapper schoolMapper;
//全查学校信息
@Override
public List<School> findAll() throws Exception {
	SchoolExample example=new SchoolExample();
	return schoolMapper.selectByExampleWithBLOBs(example);
}
//根据id值查找学校信息
@Override
public School findById(long id) throws Exception {
	return schoolMapper.selectByPrimaryKey(id);
}
//根据关键字查询学校记录
@Override
public List<School> query(String keywords) throws Exception {
	SchoolExample example=new SchoolExample();
	example.createCriteria().andNameLike("%"+keywords+"%");	
	return schoolMapper.selectByExampleWithBLOBs(example);
}
//保存或者更新一条学校记录
@Override
public void saveOrUpdate(School school) throws Exception {
	if(school.getId()==null){
		//插入一条学校记录
		schoolMapper.insert(school);
	}else{
		//更新一条学校记录
		schoolMapper.updateByPrimaryKey(school);
	}
}
//根据id值删除一条学校记录
@Override
public void deleteById(long id) throws Exception {
	schoolMapper.deleteByPrimaryKey(id);
}
//批量删除学校多条信息记录
@Override
public void batchDelete(Long[] ids) throws Exception {
	for(long id:ids){
		schoolMapper.deleteByPrimaryKey(id);
	}
		
	
}

}
