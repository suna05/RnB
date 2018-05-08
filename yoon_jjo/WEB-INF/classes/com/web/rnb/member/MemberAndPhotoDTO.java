package com.web.rnb.member;

public class MemberAndPhotoDTO {
	private String m_id;
	private String m_pw;
	private String pwConfirm;
	private String m_name;
	private String m_phone;
	private String m_birth;
	private String m_address;
	private String pp_fullpath;
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getPwConfirm() {
		return pwConfirm;
	}
	public void setPwConfirm(String pwConfirm) {
		this.pwConfirm = pwConfirm;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_birth() {
		return m_birth;
	}
	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}
	public String getM_address() {
		return m_address;
	}
	public void setM_address(String m_address) {
		this.m_address = m_address;
	}
	public String getPp_fullpath() {
		return pp_fullpath;
	}
	public void setPp_fullpath(String pp_fullpath) {
		this.pp_fullpath = pp_fullpath;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberAndPhoto[m_id="+m_id+"pp_fullpath="+pp_fullpath+"]";
	}
	
}
