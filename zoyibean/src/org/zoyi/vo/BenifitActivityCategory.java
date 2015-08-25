package org.zoyi.vo;

import java.util.List;


public class BenifitActivityCategory {

	public BenifitActivityCategory() {
		// TODO Auto-generated constructor stub
	}
	private int id ;
	private String benifitActivityCategoryName;
	private List<BenifitActivity> allBenifitActivity;//不用给我
	private int benifitActivity ;//不用给我
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBenifitActivityCategoryName() {
		return benifitActivityCategoryName;
	}
	public void setBenifitActivityCategoryName(String benifitActivityCategoryName) {
		this.benifitActivityCategoryName = benifitActivityCategoryName;
	}
	public List<BenifitActivity> getAllBenifitActivity() {
		return allBenifitActivity;
	}
	public void setAllBenifitActivity(List<BenifitActivity> allBenifitActivity) {
		this.allBenifitActivity = allBenifitActivity;
	}
	public void setBenifitActivity(int benifitActivity) {
		this.benifitActivity = benifitActivity;
	}
	public int getBenifitActivity() {
		return benifitActivity;
	}
	
}
