package com.web.rnb.photo;

import java.util.List;

public class PhotoDTO {
  private String p_title;
  private String p_writer;
  private String p_date;
  private int p_count;
  private int p_no;
  private String bp_fullpath;
  
  
  public String getBp_fullpath() {
    return bp_fullpath;
  }
  public void setBp_fullpath(String bp_fullpath) {
    this.bp_fullpath = bp_fullpath;
  }
  public int getP_count() {
    return p_count;
  }
  public void setP_count(int p_count) {
    this.p_count = p_count;
  }
  public int getP_no() {
    return p_no;
  }
  public void setP_no(int p_no) {
    this.p_no = p_no;
  }
  public String getP_title() {
    return p_title;
  }
  public void setP_title(String p_title) {
    this.p_title = p_title;
  }
  public String getP_writer() {
    return p_writer;
  }
  public void setP_writer(String p_writer) {
    this.p_writer = p_writer;
  }
  public String getP_date() {
    return p_date;
  }
  public void setP_date(String p_date) {
    this.p_date = p_date;
  }
 /* public int getP_count() {
    return p_count;
  }
  public void setP_count(int p_count) {
    this.p_count = p_count;
  }*/
  
  @Override
  public String toString() {
    return "PhotoDTO [p_title=" + p_title + ", p_writer=" + p_writer + ", p_date=" + p_date + ", p_count=" + p_count
        + ", p_no=" + p_no + ", bp_fullpath=" + bp_fullpath + "]";
  }
  
  
  
}
