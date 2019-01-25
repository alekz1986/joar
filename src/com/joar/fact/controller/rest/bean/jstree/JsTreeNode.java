package com.joar.fact.controller.rest.bean.jstree;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JsTreeNode implements Serializable {

	private String text;
	private JsTreeState state;
	private String icon;
	private String type;
	private Object extraData;
	private Vector<Object> children;


	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public JsTreeState getState() {
		return state;
	}
	public void setState(JsTreeState state) {
		this.state = state;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getExtraData() {
		return extraData;
	}
	public void setExtraData(Object extraData) {
		this.extraData = extraData;
	}
	public Vector<Object> getChildren() {
		return children;
	}
	public void setChildren(Vector<Object> children) {
		this.children = children;
	}

}
