package com.ebao.bean;

import java.util.List;

public class PolicyBean {

	private String id;
	
	


	private List<Insured> insuredList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Insured> getInsuredList() {
		return insuredList;
	}

	public void setInsuredList(List<Insured> insuredList) {
		this.insuredList = insuredList;
	}

}
