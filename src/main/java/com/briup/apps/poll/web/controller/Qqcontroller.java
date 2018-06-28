package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.service.IQqService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description = "questionnaire_question连接表关接口")
@RestController
@RequestMapping("/Qq")
public class Qqcontroller {
	@Autowired
	private IQqService qqService;

	@GetMapping("findAllQq")
	public MsgResponse findAllQq() {
		try {
			List<Qq> list = qqService.findAll();
			// 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// 返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findById")
	public MsgResponse findById(long id) {
		try {
			Qq list = qqService.findById(id);
			// 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// 返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("deleteById")
	public MsgResponse deleteById(long id) {
		try {
			qqService.deleteById(id);
			// 返回成功信息
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// 返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("batchDelete")
	public MsgResponse batchDelete(Long[] ids) {
		try {
			qqService.batchDelete(ids);
			// 返回成功信息
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// 返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("saveOrUpdate")
	public MsgResponse saveOrUpdate(Qq qq) {
		try {
			qqService.saveOrUpdate(qq);
			// 返回成功信息
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// 返回错误信息
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
