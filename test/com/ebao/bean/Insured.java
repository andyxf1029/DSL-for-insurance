package com.ebao.bean;

import java.util.List;

public class Insured {

	private Long premium;

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private List<PolicyCT> ctList;

	public List<PolicyCT> getCtList() {
		return ctList;
	}

	public void setCtList(List<PolicyCT> ctList) {
		this.ctList = ctList;
	}

	public Long getPremium() {
		return premium;
	}

	public void setPremium(Long premium) {
		this.premium = premium;
	}

}
