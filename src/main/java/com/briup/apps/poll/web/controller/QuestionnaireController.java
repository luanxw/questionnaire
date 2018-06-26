package com.briup.apps.poll.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="问卷相关模块")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Autowired
	private IQuestionnaireService questionnaireService;
	@GetMapping("findAllQuestionnaire")
	public MsgResponse findAllQuestionnaire(){
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("findByIdQuestionnaire")
	public MsgResponse findByIdQuestionnaire(long id){
		try {
			Questionnaire list = questionnaireService.findById(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@GetMapping("queryQuestionnaire")
	public MsgResponse queryQuestionnaire(String keywords){
		try {
			List<Questionnaire> list = questionnaireService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("saveOrUpdadeQuestionnaire")
	public MsgResponse saveOrUpdadeQuestionnaire(Questionnaire questionnaire){
		try {
			questionnaireService.saveOrUpdate(questionnaire);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	@PostMapping("deleteByIdQuestionnaire")
	public MsgResponse deleteByIdQuestionnaire(@RequestParam long id){
		try {
			questionnaireService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
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
