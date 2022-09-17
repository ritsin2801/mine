package com.nagarro.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.comparator.PriceComparator;
import com.nagarro.comparator.RatingComparator;
import com.nagarro.dao.TShirtDaoImp;
import com.nagarro.model.TShirt;
@Controller
public class ProductController {
	@Autowired
	TShirtDaoImp tshirtDao;
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		String colour=request.getParameter("colour");
		String size=request.getParameter("size");
		String gender=request.getParameter("gender_recommendation");
		String sortingType=request.getParameter("sortingType");
		
		
		List<TShirt> tshirt=tshirtDao.getSessionWithoutTransaction(colour, size, gender);
		if(sortingType.equals("price")) {
            Collections.sort(tshirt,new PriceComparator());
        }
        else if(sortingType.equals("rating")) {
            Collections.sort(tshirt,new RatingComparator());
        }
		mv.setViewName("Output.jsp");
		mv.addObject("tshirt",tshirt);
		return mv;
		
		
		
		
	}

}
