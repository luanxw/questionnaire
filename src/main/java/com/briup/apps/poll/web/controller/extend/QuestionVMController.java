package com.briup.apps.poll.web.controller.extend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.extend.QuestionVM;

import com.briup.apps.poll.service.extend.IQuestionVMService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问题相关接口1")
@RestController
@RequestMapping("/questionVM")

public class QuestionVMController {
	
	
	@Autowired
	private IQuestionVMService questionVMService;
	
	
	@ApiOperation(value="通过ID删除问题",
			notes="删除题目的同时会把题目下所有的选项也给删除掉")
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id){
		try {
			questionVMService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="保存或修改问题",
			notes="当id不为空表示修改，否则表示更新，保存和更新的时候需要提交选项数据")
	@PostMapping("saveOrUpdateQuestionVM")
	public MsgResponse saveOrUpdateQuestionVM(QuestionVM questionVM){
		try {
			questionVMService.saveOrUpdateQuestionVM(questionVM);
			return MsgResponse.success("保存成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="查询所所有问题信息",notes="问题中包含该问题所有的属性信息")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){

		try {
			List<QuestionVM> list = questionVMService.findAllQuestionVM();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			//返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
