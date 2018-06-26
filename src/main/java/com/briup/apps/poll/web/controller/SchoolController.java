package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="学校相关接口")
@RestController
@RequestMapping("/school")
public class SchoolController {
@Autowired
      private ISchoolService schoolService;
@ApiOperation(value="查询所有的学校信息")
//查询所有的学校信息
      @GetMapping("findAllSchool")
      public MsgResponse findAllSchool(){
    	  try {
			List<School> list=schoolService.findAll();
			//返回查询成功信息
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常信息
			return MsgResponse.error(e.getMessage());
		}
      }
@ApiOperation(value="根据id值查询一条学校记录")
 //根据id值查询一条学校记录
      @PostMapping("findSchoolById")
      public MsgResponse findSchoolById(long id){
    	  try {
			return MsgResponse.success("success",schoolService.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常信息
			return MsgResponse.error(e.getMessage());
		}
      }
@ApiOperation(value="根据关键词查询学校信息")
    //根据关键词查询学校信息
      @PostMapping("queryByKeyword")
      public MsgResponse queryByKeyWord(String keywords){
    	  try {
			return MsgResponse.success("success",schoolService.query(keywords));
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常信息
			return MsgResponse.error(e.getMessage());
		}
      }
      @ApiOperation(value="保存学校信息",notes="保存学校信息的时候不需要输入id")
      @PostMapping("saveOrUpdate")
    //插入或者更新一条学校记录
  	public MsgResponse saveOrUpdate(School school){
  		try {
			schoolService.saveOrUpdate(school);
			return MsgResponse.success("success",null);
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常信息
			return MsgResponse.error(e.getMessage());
		}
  	}
      @ApiOperation(value="根据id值删除一条学校记录")
      @PostMapping("deleteById")
  //根据id值删除一条学校记录
  	public MsgResponse deleteById(long id){
  		try {
			schoolService.deleteById(id);
			return MsgResponse.success("success",null);
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常信息
			return MsgResponse.error(e.getMessage());
		}
  	}
      @PostMapping("batchDelete")
      @ApiOperation(value="批量删除学校信息",notes="批量删除的时候中间加逗号")
  //批量删除学校记录
  	public MsgResponse batchDelete(Long[] ids){
  		try {
			schoolService.batchDelete(ids);
			return MsgResponse.success("success",null);
		} catch (Exception e) {
			e.printStackTrace();
			//抛出异常信息
			return MsgResponse.error(e.getMessage());  	
        }
    }
  }
