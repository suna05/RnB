package com.web.insideframe.dto.boarddto;

public class BoardDTO {
	private int idx;
	private String writer;
	private String btitle;
	private String bdate;
	private String btype;
	private String content;
	private int bcount=0;
	
	public BoardDTO() {}
	
	public BoardDTO(String writer, String btitle, String bdate, String btype, String content) {
		super();
		this.writer = writer;
		this.btitle = btitle;
		this.bdate = bdate;
		this.btype = btype;
		this.content = content;
	}

	public BoardDTO(String writer, String btitle, String bdate, String btype, String content, int bcount) {
		super();
		this.writer = writer;
		this.btitle = btitle;
		this.bdate = bdate;
		this.btype = btype;
		this.content = content;
		this.bcount = bcount;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
}
