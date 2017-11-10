package com.web.insideframe.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.moviedao.MovieDAO;
import com.web.insideframe.dto.moviedto.MovieDTO;

public class MovieSearchService {
	DaoFactory df=new DaoFactory();
	MovieDAO mdao=df.movieDao();
	
	public ArrayList<MovieDTO> getMovieList(String keyword){
		ArrayList<MovieDTO> mList=null;
		if(keyword.equals("actionAndThriller") || keyword.equals("romance")
				|| keyword.equals("comedy") || keyword.equals("drama") || keyword.equals("horror")){
			mList=mdao.selectCategory(keyword);
		}else if(keyword.equals("all")){
			mList=mdao.selectAll();
		}else{
			mList=mdao.selectTitle("%"+keyword+"%");
		}
		return mList;
	}
}
