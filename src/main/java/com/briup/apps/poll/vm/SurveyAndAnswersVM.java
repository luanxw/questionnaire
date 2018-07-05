package com.briup.apps.poll.vm;

import java.util.List;

import com.briup.apps.poll.bean.answers;
import com.briup.apps.poll.bean.extend.SurveyVM;

public class SurveyAndAnswersVM {
	private SurveyVM surveyVM;
	private List<answers> answers;
	
	public SurveyVM getSurveyVM() {
		return surveyVM;
	}
	public void setSurveyVM(SurveyVM surveyVM) {
		this.surveyVM = surveyVM;
	}
	public List<answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<answers> answers) {
		this.answers = answers;
	}
	
}
