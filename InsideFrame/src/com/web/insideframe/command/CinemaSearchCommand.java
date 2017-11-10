package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.moviedto.MovieDTO;
import com.web.insideframe.service.MovieSearchService;

public class CinemaSearchCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		MovieSearchService ms=new MovieSearchService();
		
		ArrayList<MovieDTO> mList=ms.getMovieList(category);
		request.setAttribute("movieList",mList);
	}

}
