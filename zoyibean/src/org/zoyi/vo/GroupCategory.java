package org.zoyi.vo;

import java.util.List;

public class GroupCategory {
	
	public GroupCategory() {
		// TODO Auto-generated constructor stub
	}
	private int id ;
	private String title ;
	//组织LOGO
	private String note ;
	private String choice ;
	private int inputnum ;
	private List<Object> allGroup ;//我需要的时候再给我
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public int getInputnum() {
		return inputnum;
	}
	public void setInputnum(int inputnum) {
		this.inputnum = inputnum;
	}
	public List<Object> getAllGroup() {
		return allGroup;
	}
	public void setAllGroup(List<Object> allGroup) {
		this.allGroup = allGroup;
	}
	
}
