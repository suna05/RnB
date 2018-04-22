package com.web.rnb.write;

import java.util.List;

public class WriteDTO {
  private int w_no;
  private String w_title;
  private String w_content;
  private String w_writer;
  private String w_date;
  private int w_count;
  
  public int getW_no() {
    return w_no;
  }
  public void setW_no(int w_no) {
    this.w_no = w_no;
  }
  public String getW_title() {
    return w_title;
  }
  public void setW_title(String w_title) {
    this.w_title = w_title;
  }
  public String getW_content() {
    return w_content;
  }
  public void setW_content(String w_content) {
    this.w_content = w_content;
  }
  public String getW_writer() {
    return w_writer;
  }
  public void setW_writer(String w_writer) {
    this.w_writer = w_writer;
  }
  public String getW_date() {
    return w_date;
  }
  public void setW_date(String w_date) {
    this.w_date = w_date;
  }
  public int getW_count() {
    return w_count;
  }
  public void setW_count(int w_count) {
    this.w_count = w_count;
  }
  @Override
  public String toString() {
    return "WriteDTO [w_no=" + w_no + ", w_title=" + w_title + ", w_content=" + w_content + ", w_writer=" + w_writer
        + ", w_date=" + w_date + ", w_count=" + w_count + "]";
  }
  
  
  
  

  
  
}
