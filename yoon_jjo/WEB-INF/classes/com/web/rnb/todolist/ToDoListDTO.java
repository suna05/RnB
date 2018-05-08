package com.web.rnb.todolist;

public class ToDoListDTO {
	private String t_no;
	private String t_content;
	private String t_writer;
	private String obtain;
	private String t_date;
	private String m_id;
	
	
	public String getT_no() {
		return t_no;
	}
	public void setT_no(String t_no) {
		this.t_no = t_no;
	}
	
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	
	public String getT_writer() {
		return t_writer;
	}
	public void setT_writer(String t_writer) {
		this.t_writer = t_writer;
	}
	public String getObtain() {
		return obtain;
	}
	public void setObtain(String obtain) {
		this.obtain = obtain;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		return "ToDoListDTO [t_no=" + t_no + ", t_content=" + t_content + ", t_writer=" + t_writer + ", obtain="
				+ obtain + ", t_date=" + t_date + ", m_id=" + m_id + "]";
	}
}
