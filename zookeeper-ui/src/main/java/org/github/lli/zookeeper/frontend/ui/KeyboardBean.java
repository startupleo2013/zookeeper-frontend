package org.github.lli.zookeeper.frontend.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class KeyboardBean {
	private String value;

	public String getValue() {
		System.out.println("Value get read!");
		return value;
	}

	public void setValue(String value) {
		System.out.println("Value get set!");
		this.value = value;
	}
}
