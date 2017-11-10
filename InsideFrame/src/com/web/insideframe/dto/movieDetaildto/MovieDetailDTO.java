package com.web.insideframe.dto.movieDetaildto;

public class MovieDetailDTO {
	private String youtubeLink;
	private String movieImage;
	private String movieInfo;
	private String mdate;
	private String mimage;
	private String mType;
	private String name;
	private String roll;
	
	public MovieDetailDTO() {
		super();
	}
	public MovieDetailDTO(String youtubeLink, String movieImage, String movieInfo, String mdate, String mimage,
			String mType, String name, String roll) {
		super();
		this.youtubeLink = youtubeLink;
		this.movieImage = movieImage;
		this.movieInfo = movieInfo;
		this.mdate = mdate;
		this.mimage = mimage;
		this.mType = mType;
		this.name = name;
		this.roll = roll;
	}
	public String getYoutubeLink() {
		return youtubeLink;
	}
	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}
	public String getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getMimage() {
		return mimage;
	}
	public void setMimage(String mimage) {
		this.mimage = mimage;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	
}
