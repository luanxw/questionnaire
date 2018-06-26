package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
@Autowired
private IGradeService gradeService;
@GetMapping("findAllGrade")
/*
 * 查询所有班级学生信息
 */
public MsgResponse findAllGrade(){
	try {
		List<Grade> list = gradeService.findAll();
		//返回成功信息
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		//返回错误信息
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@GetMapping("findByIdGrade")
/*
 * 通过ID查找班级信息
 */
public MsgResponse findByIdGrade(long id)
{
	try
	{
		return MsgResponse.success("success",gradeService.findById(id));
		
	}catch(Exception e)
	{
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@GetMapping("findAllKeywords")
/*
 * 通过关键字模糊查询
 */
public MsgResponse findAllKeywords(String keywords)
{
	try
	{
		return MsgResponse.success("success",gradeService.query(keywords));
	}catch(Exception e)
	{
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@GetMapping("deleteGradeById")
/*
 * 通过ID删除班级信息
 */
public MsgResponse deleteGradeById(@RequestParam long id)
{
	try
	{
		gradeService.deleteById(id);
		return MsgResponse.success("success",id);
	}catch(Exception e)
	{
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
}
@PostMapping("saveorupdateGrade")
/*
 * 更新或者保存班级信息
 */
public MsgResponse saveorupdateGrade(Grade grade){
	try{
		gradeService.saveOrUpdate(grade);
		return MsgResponse.success("success",null);
	}catch(Exception e){
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}

@GetMapping("batchDeleteGrade")
/*
 * 批量删除班级信息
 */
public MsgResponse batchDeleteGrade(Long[] ids){
	try{
	gradeService.batchDelete(ids);
	return MsgResponse.success("success",null);
}catch(Exception e)
{
	e.printStackTrace();
	return MsgResponse.error(e.getMessage());
}
}
}
