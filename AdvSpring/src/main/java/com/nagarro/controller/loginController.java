package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.UserDao;
import com.nagarro.watcher.Watcher;
@Controller
public class loginController {
	@Autowired
	UserDao userDao;
	@RequestMapping("/LoginCheck")
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response)throws InterruptedException{
		ModelAndView mv=new ModelAndView();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Watcher watcher = new Watcher();
		watcher.watcherThread.start();
		Thread.sleep(200);
		 
		if(userDao.isValid(username, password)) {
			mv.setViewName("home.jsp");
		}
		else {
			mv.setViewName("login.jsp");
		}
		return mv;
		
	}

}
