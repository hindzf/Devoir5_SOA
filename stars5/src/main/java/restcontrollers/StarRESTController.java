package restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hind.stars.entities.Star;
import com.hind.stars.service.StarService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StarRESTController {
	
	@Autowired
	StarService starService ; 
	
	@RequestMapping(method=RequestMethod.GET)
	List<Star> getAllStars() {
		return starService.getAllStars() ; 
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Star getStarById(@PathVariable("id") Long id) {
		return starService.getStar(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Star createStar(@RequestBody Star star) {
		return starService.saveStar(star);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Star updateStar(@RequestBody Star star ) {
		return starService.updateStar(star);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteStar(@PathVariable("id") Long id)
	{
		starService.deleteStarById(id);
	}
	
	@RequestMapping(value="/prodscat/{idType}",method = RequestMethod.GET)
	public List<Star> getStarByTypeId(@PathVariable("idType") Long idType) {
		return starService.findByTypeIdType(idType);
	}
	
	
	
	
}
