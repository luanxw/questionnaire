package com.briup.apps.poll.web.controller;

import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	
	@GetMapping("findAllClazz")
	@ApiOperation(value="查询班级信息")
	public MsgResponse findAllCourse(){
		
		try {
			List<Clazz> list =  clazzService.findAll();
	
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			//返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findClazzById")
	@ApiOperation(value="通过id查询班级信息")
	public MsgResponse findClazzById(long id){
		try {
			Clazz list = clazzService.findById(id);
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			//返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@ApiOperation(value="删除班级信息")
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(@RequestParam long id){
		try {
		      clazzService.deleteById(id);
		      return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
   
	
	@ApiOperation(value="关键字查询班级信息")
	@GetMapping("QueryClazz")
	public MsgResponse  QueryClazz(String keywords){
		try {
			List<Clazz> list = clazzService.query(keywords);
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			//返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
   
	
	@ApiOperation(value="保存或者更新班级信息")
	@PostMapping("saveOrUpdateClazzById")
	public MsgResponse saveClazzById(Clazz clazz){
		try{
			clazzService.saveOrUpdate(clazz);
			return MsgResponse.success("success", clazz);
		} catch (Exception e) {
			e.printStackTrace();
				return MsgResponse.error(e.getMessage());
		}		
	}

	@ApiOperation(value="保存或者更新班级信息")
	@GetMapping("batchDeleteById")
	public MsgResponse batchDeleteById(Long[] ids){
		try{
			clazzService.batchDeleteById(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
				return MsgResponse.error(e.getMessage());
		}		
	}
}
