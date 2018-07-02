package com.briup.apps.poll.dao.extend;


import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionVM;

public interface QuestionVMMapper {
	
	void saveOrUpdateQuestion(QuestionVM questionVM);
	 
	List<QuestionVM> selectAllQuestion();
	
}
