package com.endava.springMVC.model;

import java.util.List;

public class NavigationBar {
	private int id;
	private String content;
	private boolean isUsed;
	private List navBars;

	public List getNavBars() {
		return navBars;
	}

	public void setNavBars(List navBars) {
		this.navBars = navBars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "NavigationBar [content=" + content + ", isUsed=" + isUsed + "]";
	}

}
