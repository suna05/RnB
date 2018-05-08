package com.web.rnb.photo;

public class ProfilePhotoDTO {
	private String pp_fullpath;
	private String m_id;

	public String getPp_fullpath() {
		return pp_fullpath;
	}
	public void setPp_fullpath(String pp_fullpath) {
		this.pp_fullpath = pp_fullpath;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProfilePhotoDTO [pp_fullpath="+pp_fullpath+", m_id="+m_id+"]";
	}
	
}
