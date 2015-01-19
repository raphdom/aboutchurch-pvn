package net.aboutchurch.pvn.controller;

import net.aboutchurch.common.services.ArticlePublicService;
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
public class ArticleController {
	
	@Autowired
	private ArticlePublicService articlePublicService;
	
	@RequestMapping(value="/article.action", method = RequestMethod.GET)
	public ModelAndView article(@RequestParam Integer id) throws Exception {
		
		ModelAndView model = new ModelAndView("article");
		
		ResultObject result = articlePublicService.get(id);
		
		model.addObject("article",result.getData().get(0));
		
		return model;
		
	}

}
