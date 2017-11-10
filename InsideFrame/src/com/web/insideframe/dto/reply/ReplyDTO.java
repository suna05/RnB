package com.web.insideframe.dto.reply;

public class ReplyDTO {
	private int commentNo;
	private int comment_board;
	private String commentId;
	private String commentDate;
	private String commentContent;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(int commentNo, int comment_board, String commentId, String commentDate, String commentContent) {
		super();
		this.commentNo = commentNo;
		this.comment_board = comment_board;
		this.commentId = commentId;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getComment_board() {
		return comment_board;
	}
	public void setComment_board(int comment_board) {
		this.comment_board = comment_board;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String toString(){
		return commentNo+" "+commentContent;
	}
}
