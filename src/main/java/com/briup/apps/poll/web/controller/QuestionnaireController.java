package com.briup.apps.poll.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问卷相关模块")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Autowired
	private IQuestionnaireService questionnaireService;
	@ApiOperation("查询所有问卷信息")
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("根据ID查询问卷问题信息")
	@GetMapping("findByIdQuestionnaireVM")
	public MsgResponse findByIdQuestionnaireVM(long id){
		try {
			QuestionnaireVM listVM = questionnaireService.findVMById(id);
			return MsgResponse.success("success", listVM);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("根据关键字查询")
	@GetMapping("queryQuestionnaire")
	public MsgResponse queryQuestionnaire(String keywords){
		try {
			List<Questionnaire> list = questionnaireService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("保存或者修改问卷信息")
	@PostMapping("saveOrUpdadeQuestionnaire")
	public MsgResponse saveOrUpdadeQuestionnaire(Questionnaire questionnaire,long[]questionIds){
		try {
			questionnaireService.saveOrUpdate(questionnaire, questionIds);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="根据ID删除问卷信息",notes="删除问卷时会把问卷和问题的关系解除掉，而问题保留")
	@GetMapping("deleteByIdQuestionnaire")
	public MsgResponse deleteByIdQuestionnaire(long id){
		try {
			questionnaireService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("批量删除问卷信息")
	@PostMapping("batchDeleteQuestionnaire")
	public MsgResponse batchDeleteQuestionnaire(@RequestParam List<Long>ids){
		try {
			questionnaireService.batchDelete(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	}
	

