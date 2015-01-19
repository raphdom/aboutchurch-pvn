package net.aboutchurch.pvn.controller;

import javax.servlet.http.HttpServletResponse;

import net.aboutchurch.common.services.CloudPublicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class FileController {
	
	
	@Autowired
	private CloudPublicService cloudPublicService;
	
	@RequestMapping(value="/getThumb.action", method = RequestMethod.GET)
	public void get(@RequestParam Integer id, 
					@RequestParam(required=false) Integer dataType, 
					@RequestParam(required=false) Integer width, 
					@RequestParam(required=false) Integer height, 
					@RequestParam(required=false) boolean exactlySize,
					final HttpServletResponse response) throws Exception {

		byte[] fileByteArray = null;
		
		if(width != null && width > 0){
			fileByteArray = cloudPublicService.getThumb(id, width, height, exactlySize);
		}else{
			fileByteArray = cloudPublicService.getThumb(id, dataType);
		}

		if (fileByteArray != null && fileByteArray.length > 0){
			response.addHeader("Cache-Control", "public no-transform max-age=43200");
			response.getOutputStream().write(fileByteArray);
			response.getOutputStream().flush();
		}

	}

}
