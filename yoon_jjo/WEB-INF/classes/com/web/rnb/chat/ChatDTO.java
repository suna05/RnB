package com.web.rnb.chat;

public class ChatDTO {
	private int seq_no;
	private String m_id;
	private String message;
	private String pp_fullpath;
	private String c_date;
	
	public int getSeq_chat() {
		return seq_no;
	}
	public void setSeq_chat(int seq_chat) {
		this.seq_no = seq_chat;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPp_fullpath() {
		return pp_fullpath;
	}
	public void setPp_fullpath(String pp_fullpath) {
		this.pp_fullpath = pp_fullpath;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	@Override
	public String toString() {
		return "ChatDTO [seq_chat=" + seq_no + ", m_id=" + m_id + ", message=" + message + ", pp_fullpath="
				+ pp_fullpath + ", c_date=" + c_date + "]";
	}
	
	
}
