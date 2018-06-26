/*
 * 答案选项Controller
 * @author:Wsiri
 * Date:2018/6/26
 */
package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项相关接口")
@Controller
@RequestMapping("/options")
public class OptionsController {
	
	@Autowired
	private IOptionsService iOptionsService;
	
	
	//查找所有选项
	@ApiOperation(value="查询全部")
	@GetMapping("findAllOptions")
	@ResponseBody
	public MsgResponse findAllOptions(){
		List<Options> list;
		try {
			list = iOptionsService.findAllOptions();
			return MsgResponse.success("查找成功",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	//根据Id查找
	@ApiOperation(value="通过id查询")
	@GetMapping("findById")
	@ResponseBody
	public MsgResponse findById(@RequestParam long id){
		Options options=new Options();
		try {
			options=iOptionsService.findById(id);
			return MsgResponse.success("查找成功", options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	//根据关键字查找
	@ApiOperation(value="通过关键字查询")
	@PostMapping("findByKeywords")
	@ResponseBody
	public MsgResponse findByKewords(@RequestParam String keywords){
		List<Options> list;
		try {
			list=iOptionsService.query(keywords);
			return MsgResponse.success("查找成功", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	//保存或更新
	@ApiOperation(value="保存或更新")
	@PostMapping("saveOrUpdate")
	@ResponseBody
	public MsgResponse saveOrUpdate(Options options){
		try {
			iOptionsService.saveOrUpdate(options);
			return MsgResponse.success("添加成功", options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//根据ID删除
	@ApiOperation(value="通过id删除")
	@GetMapping("deleteById")
	@ResponseBody
	public MsgResponse deleteById(@RequestParam long id){
		try {
			int count=iOptionsService.deleteById(id);
			if(count>0)
			return MsgResponse.justSuccess("删除成功");
			else return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	//批量删除
	@ApiOperation(value="批量删除")
	@PostMapping("batchDelete")
	@ResponseBody
	public MsgResponse batchDelete(Long[] ids){
		try {
			iOptionsService.batchDelete(ids);
			return MsgResponse.justSuccess("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
}
