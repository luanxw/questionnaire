package com.briup.apps.poll.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.bean.extend.CourseVM;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.dao.extend.CourseVMMapper;
import com.briup.apps.poll.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CourseVMMapper courseMapperVM;

	@Override
	public List<Course> findAll() throws Exception {
		CourseExample example = new CourseExample();
		
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Course findById(long id) throws Exception {

		return courseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Course> query(String keywords) throws Exception {
		
		CourseExample example = new CourseExample();
		//添加了
		example.createCriteria().andNameLike("%"+keywords+"%");
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Course course) throws Exception {
		
		if(course.getId()!=null){
			//更新
			courseMapper.updateByPrimaryKey(course);
		}else{
			//插入
			courseMapper.insert(course);
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
	
		courseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception{

		for(long id :ids){
			courseMapper.deleteByPrimaryKey(id);
		}
	}
//扩展方法	
	@Override
	public List<CourseVM> findAllCourseVM() throws Exception {
		
		return courseMapperVM.selectAll();
	}

	@Override
	public void saveOrUpdateVM(CourseVM courseVM) throws Exception {
		//先分离CourseVM,从中获得course , 
		
	}
}
