package com.web.insideframe.service;

import java.util.ArrayList;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.movieDetaildao.MovieDetailDAO;
import com.web.insideframe.dao.moviedao.MovieDAO;
import com.web.insideframe.dto.movieDetaildto.MovieDetailDTO;
import com.web.insideframe.dto.moviedto.MovieDTO;

public class MovieDetailViewService {
	DaoFactory df=new DaoFactory();
	MovieDetailDAO mddao=df.movieDetailDao();

	public MovieDTO getMovieInfo(int movieNo){
		return mddao.getMovieInfo(movieNo); 
	}
	public ArrayList<MovieDetailDTO> getPeopleList(int movieNo){
		return mddao.getMovieDetailList(movieNo);
	}
}
