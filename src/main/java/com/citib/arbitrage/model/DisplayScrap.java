package com.citib.arbitrage.model;

import java.io.Serializable;

import ch.qos.logback.core.net.SyslogOutputStream;

public class DisplayScrap implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	String title;
	String description;
    String link;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		System.out.println("title:"+title);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "SavedStock [title=" + title + ", description=" + description + ", link=" + link + "]";
	}
}
