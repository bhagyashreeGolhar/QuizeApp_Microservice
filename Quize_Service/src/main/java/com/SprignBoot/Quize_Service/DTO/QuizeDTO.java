package com.SprignBoot.Quize_Service.DTO;

import lombok.Data;

public class QuizeDTO {

	 String categoryName;
	 String title;
	 int numQ;
	 public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumQ() {
		return numQ;
	}
	public void setNumQ(int numQ) {
		this.numQ = numQ;
	}
	
}
	