package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
//import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
//import com.briup.apps.poll.service.extend.IQuestionVMService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
	@Api(description="问题相关接口")
	@RestController
	@RequestMapping("/question")
	
	public class QuestionContorller {
		@Autowired
		private IQuestionService questionService;

		
		/*
		 * @ApiOperation(value="通过ID删除问题",
		 * 
				notes="删除题目的同时会把题目下所有的选项也给删除掉")
		@GetMapping("deleteQuestionById")
		public MsgResponse deleteQuestionById(long id){
			try {
				questionService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		 */
		@ApiOperation(value="保存或修改问题",
				notes="当id不为空表示修改，否则表示更新，保存和更新的时候需要提交选项数据")
		@PostMapping("saveOrUpdateQuestion")
		public MsgResponse saveOrUpdateQuestion(QuestionVM questionVM){
			try {
				questionService.saveOrUpdateQuestionVM(questionVM);
				return MsgResponse.success("success", questionVM);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
			
		}
		
		
		
		@ApiOperation(value="查询所有问题",notes="问题中包含该问题所有属性的信息")
		@GetMapping("findAllQuestionVM")
		public MsgResponse findAllQuestionVM(){

			try {
				List<QuestionVM> list = questionService.findAllQuestionVM();
				//返回成功信息
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				//返回错误信息
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	
				
		@ApiOperation(value="查询所有信息",notes="单表")
		@GetMapping("findAllQuestion")
		public MsgResponse findAllQuestion(){
			try {
				List<Question> list = questionService.findAll();
				//返回成功信息
				return MsgResponse.success("success", list);
			} catch (Exception e) {
				//返回错误信息
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
	@ApiOperation(value="通过id查询信息")
	@GetMapping("findQuestionById")	
	public MsgResponse findById(long id){
		try{
			//List<Question list = questionService.findById();
		Question list=	questionService.findById(id);
			return MsgResponse.success("success",list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	}
	@ApiOperation(value="模糊查询信息")
	@GetMapping("queryQuestion")
	public MsgResponse queryQuestion(String keywords){
		try {
			//List<Question> list= questionService.query(keywords);
			//返回成功信息
			return MsgResponse.success("success",questionService.query(keywords));
		} catch (Exception e) {
			//返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	  @ApiOperation(value="通过id删除信息")
	  @GetMapping("deleteById")	
	public MsgResponse deleteById(long id){
		try{
			questionService.deleteById(id);
			return MsgResponse.success("success",null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	}
	
	 
	/*
	 * @ApiOperation(value="保存修改信息")
	 */
	
	@ApiOperation(value="批量删除信息")
	@GetMapping("batchQuestion")
	public MsgResponse batchDelete(Long[] ids){
		try{
			questionService.batchDelete(ids);
			return MsgResponse.success("success",null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	}
}
