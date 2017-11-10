package com.web.insideframe.dto.movieReply;

public class MovieReplyDTO {
	private int commentNo;
	private int comment_movieNo;
	private String commentId;
	private String commentDate;
	private String commentContent;
	
	
	public MovieReplyDTO() {
		super();
	}
	public MovieReplyDTO(int commentNo, int comment_movieNo, String commentId, String commentDate,
			String commentContent) {
		super();
		this.commentNo = commentNo;
		this.comment_movieNo = comment_movieNo;
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
	public int getComment_movieNo() {
		return comment_movieNo;
	}
	public void setComment_movieNo(int comment_movieNo) {
		this.comment_movieNo = comment_movieNo;
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
	
	
}
