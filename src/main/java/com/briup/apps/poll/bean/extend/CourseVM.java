package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Survey;

public class CourseVM {

	private long id;
	private String name;
	private String description;
    private String period;
    private List<Survey> survey;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public List<Survey> getSurvey() {
		return survey;
	}
	public void setSurvey(List<Survey> survey) {
		this.survey = survey;
	}
}
