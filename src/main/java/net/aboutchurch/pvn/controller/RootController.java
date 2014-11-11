package net.aboutchurch.pvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jrdevel.aboutus.core.calendar.EventService;
import com.jrdevel.aboutus.core.common.to.ResultObject;
import com.jrdevel.aboutus.core.site.album.AlbumService;
import com.jrdevel.aboutus.core.site.article.ArticleService;
import com.jrdevel.aboutus.core.site.banner.BannerService;

/**
 * @author Raphael Domingues
 *
 */
@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(){
		
		ModelAndView model = new ModelAndView("index");
		
		//Banners
		ResultObject resultBanners = bannerService.listHomePage();
		model.addObject("banners", resultBanners.getData());
		
		//Articles
		ResultObject resultArticles = articleService.listSite(null);
		model.addObject("articles", resultArticles.getData());
		
		//Albuns
		ResultObject resultAlbuns = albumService.listHomePage(5);
		model.addObject("albuns", resultAlbuns.getData());
		
		//Events
		ResultObject resultEvents = eventService.listHomePage();
		model.addObject("events", resultEvents.getData());
		
		return model;
		
	}

}
