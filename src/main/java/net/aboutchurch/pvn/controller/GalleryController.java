package net.aboutchurch.pvn.controller;

import java.util.List;

import net.aboutchurch.common.dto.CategoryListDTO;
import net.aboutchurch.common.services.AlbumPublicService;
import net.aboutchurch.common.services.CategoryPublicService;
import net.aboutchurch.common.to.ResultObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class GalleryController {
	
	@Autowired
	private CategoryPublicService categoryPublicService;
	
	@Autowired
	private AlbumPublicService albumPublicService;
	
	
	@RequestMapping(value="/galeria/{type}", method = RequestMethod.GET)
	public ModelAndView gallery(@PathVariable String type) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("/gallery");
		
		modelAndView.addObject("categories", getCategoriesByParent(0,type));
		modelAndView.addObject("type", type);
		
		return modelAndView;
		
	}
	
	private List<CategoryListDTO> getCategoriesByParent(int parent, String type){
		
		List<CategoryListDTO> categories = null;
		
		if (type.equals("videos")){
			categories = categoryPublicService.listCategoryByParent(parent, false, true);
		}else{
			categories = categoryPublicService.listCategoryByParent(parent, true, false);
		}
		
		return categories;
		
	}
	
	@RequestMapping(value="/galeria/albuns/categoria/{id}", method = RequestMethod.GET)
	public ModelAndView categoriesAlbuns(@PathVariable Integer id) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("/gallery");
		
		modelAndView.addObject("categories", getCategoriesByParent(id,"albuns"));
		
		ResultObject resultObject = albumPublicService.listByCategory(id);
		modelAndView.addObject("albuns", resultObject.getData());
		
		modelAndView.addObject("type", "albuns");
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/galeria/videos/categoria/{id}", method = RequestMethod.GET)
	public ModelAndView categoriesVideos(@PathVariable Integer id) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("/gallery");
		
		modelAndView.addObject("categories", getCategoriesByParent(id,"videos"));
		modelAndView.addObject("type", "videos");
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/galeria/album/{id}", method = RequestMethod.GET)
	public ModelAndView album(@PathVariable Integer id) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("/album");
		
		ResultObject resultObject = albumPublicService.get(id);
		
		modelAndView.addObject("album", resultObject.getData().get(0));
		
		return modelAndView;
		
	}

}
