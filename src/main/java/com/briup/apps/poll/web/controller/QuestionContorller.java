package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;

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

		/*@Autowired
		private IQuestionVMService questionVMService;
		
		@ApiOperation(value="查询所有信息",notes="单表")
		@GetMapping("findAllQuestionVM")
		public MsgResponse findAllQuestionVM1(){

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
	*/
		
 
		
		
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
	@ApiOperation(value="通过问题查询信息")
	@GetMapping("queryQuestion")
	public MsgResponse query(String keywords){
		try {
			List<Question> list= questionService.query(keywords);
			//返回成功信息
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			//返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="通过id删除信息")
	@GetMapping("deleteQuestionById")	
	public MsgResponse deleteById(long id){
		try{
			questionService.deleteById(id);
			return MsgResponse.success("success",null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	}
	
	@ApiOperation(value="保存修改信息")
	@GetMapping("saveOrUpdateQuestion")
	public MsgResponse saveOrUpdate(Question question){
		try {
			questionService.saveOrUpdate(question);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
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
