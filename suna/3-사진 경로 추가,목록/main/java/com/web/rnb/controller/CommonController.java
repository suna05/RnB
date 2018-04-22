package com.web.rnb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

	
	@RequestMapping(value="/index.do")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	
	
  	   @RequestMapping(value="/photo.do")
  	    public ModelAndView photo(ModelAndView mav) {
  	        mav.setViewName("photo");
  	        return mav;
  	    }
  	   
  	   @RequestMapping(value="/photoList.do")
       public ModelAndView photoList(ModelAndView mav) {
           mav.setViewName("photolist");
           return mav;
       }
  	   
       @RequestMapping(value="/write.do")
       public ModelAndView write(ModelAndView mav) {
           mav.setViewName("write");
           return mav;
       }
  	   
       @RequestMapping(value="/writelist.do")
       public ModelAndView writeList(ModelAndView mav) {
           mav.setViewName("writelist");
           return mav;
       }
       
       
       @RequestMapping(value="/writedetail.do")
       public ModelAndView writeDetailList(ModelAndView mav) {
           mav.setViewName("writedetail");
           return mav;
       }
       
       
}
