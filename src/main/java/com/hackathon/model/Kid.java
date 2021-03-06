package com.hackathon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Kid {

	private String name;
	private String sold;
	private List<Task> tasks;

	public Kid(@JsonProperty("name") String name, @JsonProperty("sold") String sold, List<Task> tasks) {
		this.name = name;
		this.sold = sold;
		this.tasks = tasks;
	}

	public String getName() {
		return name;
	}

	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	@Override
	public String toString() {
		return "Kid [name=" + name + ", sold=" + sold + ", tasks=" + tasks + "]";
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
