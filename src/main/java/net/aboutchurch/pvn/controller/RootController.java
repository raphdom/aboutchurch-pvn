package net.aboutchurch.pvn.controller;

import net.aboutchurch.common.services.AlbumPublicService;
import net.aboutchurch.common.services.ArticlePublicService;
import net.aboutchurch.common.services.BannerPublicService;
import net.aboutchurch.common.services.EventPublicService;
import net.aboutchurch.common.to.ResultObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Raphael Domingues
 *
 */
@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	private ArticlePublicService articlePublicService;
	
	@Autowired
	private BannerPublicService bannerPublicService;
	
	@Autowired
	private AlbumPublicService albumPublicService;
	
	@Autowired
	private EventPublicService eventPublicService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView model = new ModelAndView("index");
		//Banners
		ResultObject resultBanners = bannerPublicService.list(null);
		model.addObject("banners", resultBanners.getData());
		
		//Articles
		ResultObject resultArticles = articlePublicService.list(null);
		model.addObject("articles", resultArticles.getData());
		
		//Albuns
		ResultObject resultAlbuns = albumPublicService.list(5);
		model.addObject("albuns", resultAlbuns.getData());
		
		//Events
		ResultObject resultEvents = eventPublicService.list(null);
		model.addObject("events", resultEvents.getData());
		
		return model;
		
	}

}
