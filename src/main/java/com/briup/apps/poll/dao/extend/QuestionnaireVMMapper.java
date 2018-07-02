package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface QuestionnaireVMMapper {

	List<QuestionnaireVM> selectAll();
	QuestionnaireVM selectById(long id);

}
