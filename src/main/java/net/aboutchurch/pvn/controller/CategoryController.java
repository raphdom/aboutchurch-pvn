package net.aboutchurch.pvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jrdevel.aboutus.core.common.to.ResultObject;
import com.jrdevel.aboutus.core.site.album.AlbumService;
import com.jrdevel.aboutus.core.site.article.ArticleService;
import com.jrdevel.aboutus.core.site.category.CategoryService;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private AlbumService albumService;
	
	@RequestMapping(value="/category.action", method = RequestMethod.GET)
	public ModelAndView category(@RequestParam Integer id) throws Exception {
		
		ModelAndView model = new ModelAndView("category");
		
		ResultObject result = service.get(id);
		
		model.addObject("category",result.getData().get(0));
		
		ResultObject articles = articleService.listByCategory(id);
		
		model.addObject("articles",articles.getData());
		
		ResultObject albuns = albumService.listByCategory(id);
		
		model.addObject("albuns",albuns.getData());
		
		return model;
		
	}

}
