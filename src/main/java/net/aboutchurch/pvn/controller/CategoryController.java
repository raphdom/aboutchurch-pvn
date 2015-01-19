package net.aboutchurch.pvn.controller;

import net.aboutchurch.common.services.AlbumPublicService;
import net.aboutchurch.common.services.ArticlePublicService;
import net.aboutchurch.common.services.CategoryPublicService;
import net.aboutchurch.common.to.ResultObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryPublicService categoryPublicService;
	
	@Autowired
	private ArticlePublicService articlePublicService;
	
	@Autowired
	private AlbumPublicService albumPublicService;
	
	@RequestMapping(value="/category.action", method = RequestMethod.GET)
	public ModelAndView category(@RequestParam Integer id) throws Exception {
		
		ModelAndView model = new ModelAndView("category");
		
		ResultObject result = categoryPublicService.get(id);
		
		model.addObject("category",result.getData().get(0));
		
		ResultObject articles = articlePublicService.listByCategory(id);
		
		model.addObject("articles",articles.getData());
		
		ResultObject albuns = albumPublicService.listByCategory(id);
		
		model.addObject("albuns",albuns.getData());
		
		return model;
		
	}

}
