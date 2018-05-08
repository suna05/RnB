package com.web.rnb.photo;

public class BoardPhotoDTO {
    private String bp_fullpath;
    private int p_no;
    
    public int getP_no() {
      return p_no;
    }
    public void setP_no(int p_no) {
      this.p_no = p_no;
    }
    public String getBp_fullpath() {
        return bp_fullpath;
    }
    public void setBp_fullpath(String Bp_fullpath) {
        this.bp_fullpath = Bp_fullpath;
    }
	@Override
	public String toString() {
		return "BoardPhotoDTO [bp_fullpath=" + bp_fullpath + ", p_no=" + p_no + "]";
	}
    
    
    
}