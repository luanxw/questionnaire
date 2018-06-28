package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.CourseVM;

public interface CourseVMMapper {
	
 List<CourseVM>  selectAll();
 void saveOrUpdate(CourseVM courseVM);
}
