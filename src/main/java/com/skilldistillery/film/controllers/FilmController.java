package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.data.FilmDaoJdbcImpl;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao = new FilmDaoJdbcImpl();
	
	@RequestMapping(path = {"home.do", "/"})
	public String goToHome() {
		return "WEB-INF/home.jsp";
	}
	
	
	@RequestMapping(path = "home.do", method = RequestMethod.GET, params = "film")
	public ModelAndView getFilmByID(@RequestParam("film") int filmID) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDao.findFilmById(filmID));
		mv.setViewName("WEB-INF/displayFilm.jsp");
	
		return mv;
	}
	@RequestMapping(path = "home.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView getFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("films", filmDao.searchByKeyword(keyword));
		mv.setViewName("WEB-INF/displayFilms.jsp");
		
		return mv;
	}
}