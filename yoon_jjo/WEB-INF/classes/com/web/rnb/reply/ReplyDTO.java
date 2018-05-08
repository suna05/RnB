package com.web.rnb.reply;

public class ReplyDTO {
  private int r_no;
  private String r_writer;
  private String r_content;
  private String r_date;
  
  private int w_no;
  
  public int getW_no() {
    return w_no;
  }
  public void setW_no(int w_no) {
    this.w_no = w_no;
  }
  public int getR_no() {
    return r_no;
  }
  public void setR_no(int r_no) {
    this.r_no = r_no;
  }
  public String getR_writer() {
    return r_writer;
  }
  public void setR_writer(String r_writer) {
    this.r_writer = r_writer;
  }
  public String getR_content() {
    return r_content;
  }
  public void setR_content(String r_content) {
    this.r_content = r_content;
  }
  public String getR_date() {
    return r_date;
  }
  public void setR_date(String r_date) {
    this.r_date = r_date;
  }
  @Override
  public String toString() {
    return "ReplyDTO [r_no=" + r_no + ", r_writer=" + r_writer + ", r_content=" + r_content + ", r_date=" + r_date
        + "]";
  }
}
