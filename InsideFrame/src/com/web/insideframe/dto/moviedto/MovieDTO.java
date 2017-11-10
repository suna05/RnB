package com.web.insideframe.dto.moviedto;

public class MovieDTO {
	private int movieNo;
	private String mTitle;
	private String movieImage;
	private String director;
	private String youtubeLink;
	private String category;
	private String mdate;
	private String movieInfo;
	private int like;
	private int mcount;
	
	public MovieDTO() {}
	
	public MovieDTO(int movieNo, String mTitle, String movieImage, String director, String youtubeLink,
			String category, String mdate, int like, int mcount) {
		super();
		this.movieNo = movieNo;
		this.mTitle = mTitle;
		this.movieImage = movieImage;
		this.director = director;
		this.youtubeLink = youtubeLink;
		this.category = category;
		this.mdate = mdate;
		this.like = like;
		this.mcount = mcount;
	}
	
	public MovieDTO(int movieNo, String mTitle, String movieImage, String director, String youtubeLink, String category,
			String mdate, String movieInfo, int like, int mcount) {
		super();
		this.movieNo = movieNo;
		this.mTitle = mTitle;
		this.movieImage = movieImage;
		this.director = director;
		this.youtubeLink = youtubeLink;
		this.category = category;
		this.mdate = mdate;
		this.movieInfo = movieInfo;
		this.like = like;
		this.mcount = mcount;
	}

	public String getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}

	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getYoutubeLink() {
		return youtubeLink;
	}
	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getCount() {
		return mcount;
	}
	public void setCount(int count) {
		this.mcount = count;
	}
	
	public String toString(){
		return movieNo+" "+mTitle+" "+director;
	}
}
