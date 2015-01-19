package net.aboutchurch.pvn.controller;

import java.util.List;

import net.aboutchurch.common.dto.EventListDTO;
import net.aboutchurch.common.services.EventPublicService;
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
public class EventController {
	
	@Autowired
	private EventPublicService eventPublicService;
	
	@RequestMapping(value="/evento/{id}", method = RequestMethod.GET)
	public ModelAndView article(@PathVariable Integer id) throws Exception {
		
		ModelAndView model = new ModelAndView("/event");
		
		ResultObject resultEvents = eventPublicService.list(4);
		List<Object> events = resultEvents.getData();
		
		EventListDTO currentEvent = null;
		
		for(Object event : events){
			EventListDTO ev = (EventListDTO) event;
			if (Integer.compare(ev.getId(), id)==0){
				currentEvent = ev;
				break;
			}
		}
		
		ResultObject result = eventPublicService.get(currentEvent.getEid());
		
		model.addObject("event",result.getData().get(0));
		model.addObject("eventRecurrence",currentEvent);
		
		return model;
		
	}

}
