package com.hind.stars.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hind.stars.entities.Star;
import com.hind.stars.service.StarService;


	@Controller
	public class StarController {
		@Autowired
		StarService starService;
		
		@RequestMapping("/showCreate")
		public String showCreate(ModelMap modelMap)
		{
			modelMap.addAttribute("star" , new Star()) ; 
			modelMap.addAttribute("mode","new") ;
			return "formStar"; 
		}
		
		@RequestMapping("/Home")
		public String Home()
		{
			return "template";
		}
		
		
		/*@RequestMapping("/saveStar")
		public String saveStar(@ModelAttribute("star") Star star,
			@RequestParam("date") String date,ModelMap modelMap) throws ParseException
			{
				//conversion de la date
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				Date dateDiscovered = dateformat.parse(String.valueOf(date));
				star.setDateDiscovered(dateDiscovered);
				Star saveStar = starService.saveStar(star);
				String msg ="Star enregistré avec Id "+saveStar.getIdStar();
				modelMap.addAttribute("msg", msg);
				return "createStar";
			}*/
		
		@RequestMapping("/saveStar")
		public String saveStar (@Valid Star star , BindingResult bindingResult) {
			
			if (bindingResult.hasErrors()) return "formStar" ; 
			
			
			starService.saveStar(star) ;
			return "formStar";
		}
		
		
		@RequestMapping("/ListeStars")
		public String listeStars(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
		{
		Page<Star> stars = starService.getAllStarsParPage(page, size);
		modelMap.addAttribute("stars", stars);
		modelMap.addAttribute("pages", new int[stars.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size" , size) ;
		return "listeStars";
		}
		
		@RequestMapping("/supprimerStar")
		public String supprimerStar(@RequestParam("id") Long id,
		ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
		{
			starService.deleteStarById(id);
			Page<Star> stars = starService.getAllStarsParPage(page,size);
			modelMap.addAttribute("stars", stars);
			modelMap.addAttribute("pages", new int[stars.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeStars";
		}
		
		@RequestMapping("/modifierStar")
		public String editerStar(@RequestParam("id") Long id,ModelMap modelMap)
		{
		Star s= starService.getStar(id);
		modelMap.addAttribute("star", s);
		modelMap.addAttribute("mode" , "edit");
		return "formStar";
		}
		
		@RequestMapping("/updateStar")
		public String updateStar(@ModelAttribute("star") Star star,
		@RequestParam("date") String date,ModelMap modelMap) throws ParseException
		{
			//conversion de la date
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateDiscovered = dateformat.parse(String.valueOf(date));
			star.setDateDiscovered(dateDiscovered);
			starService.updateStar(star);
			List<Star> stars = starService.getAllStars();
			modelMap.addAttribute("stars", stars);
			return "listeStars";
			}
	}


