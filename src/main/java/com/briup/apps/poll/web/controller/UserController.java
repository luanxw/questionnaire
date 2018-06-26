package com.briup.apps.poll.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(description="用户相关接口")
public class UserController {
	@Autowired 
	private IUserService userService;
	//查询所有用户
	@GetMapping("findAll")
	@ApiOperation(value="查询所有用户信息")
	public MsgResponse findAll(){
		try {
			List<User> list=userService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error("error"+e.getMessage());
		}
	}
	//通过ID查询用户
	@GetMapping("findById")
	@ApiOperation(value="查询某个ID用户信息",notes="输入用户ID")
	public MsgResponse findById(long id){
		try {
			return MsgResponse.success("success",  userService.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error("error"+e.getMessage());
		}
	}
	//通过关键字查询用户
	@ApiOperation(value="通过关键字查询信息",notes="输入姓名关键字")
	@GetMapping("findKeyword")
	public MsgResponse findkeyword(String keyword){
		try {
			List<User> list=userService.query(keyword);
			return MsgResponse.success("success",  list);
		} catch (Exception e) {
			// TODO: handle exception
			return MsgResponse.error("error"+e.getMessage());
		}
	}
	//更新或插入用户
	@ApiOperation(value="保存或修改用户信息",notes="保存用户信息的时候不需要输入ID")
	@PostMapping("SaveOrUpdate")
	public String saveOrupdate(User user){
		try {
			userService.saveOrupdate(user);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error"+e.getMessage();
		}
		
	}
	//通过ID删除用户
	@GetMapping("deleteById")
	@ApiOperation(value="通过ID删除用户信息",notes="输入ID")
	public String deleteById(long id){
		try {
			userService.deleteById(id);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error"+e.getMessage();
		}
	}
	//批量删除用户
	@GetMapping("batchDelete")
	@ApiOperation(value="批量删除用户信息",notes="输入用户ID时使用,隔开")
     public MsgResponse batchdelete(Long[] ids){
    	 try {
    		 userService.batchdelete(ids);
    		 return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error("error");
		}
     }
}
