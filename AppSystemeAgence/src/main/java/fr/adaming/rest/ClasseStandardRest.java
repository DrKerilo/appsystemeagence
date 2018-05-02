package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;

@RestController
public class ClasseStandardRest {
	
	@Autowired
	private IClasseStandardService csService;
		
	@RequestMapping(value="/classeStandard", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ClasseStandard addClasseStandard(@RequestBody ClasseStandard cs) {
		return csService.addClasseStandard(cs);
	}
	
	@RequestMapping(value="/classeStandard", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public ClasseStandard updateClasseStandard(@RequestBody ClasseStandard cs) {
		return csService.updateClasseStandard(cs);
	}
	
	@RequestMapping(value="/classeStandard/{pId}", method=RequestMethod.DELETE)
	public int deleteClasseStandard(@PathVariable("pId") int id) {
		return csService.deleteClasseStandard(id);
	}
	
	@RequestMapping(value="/listeCS", method=RequestMethod.GET, produces="application/json")
	public List<ClasseStandard> getAllClasseStandard() {
		return csService.getAllClasseStandard();
	}
	
	@RequestMapping(value="/classeStandard", method=RequestMethod.GET, produces="application/json")
	public ClasseStandard getClasseStandardById(@RequestParam("pId")int id) {
		return csService.getClasseStandardById(id);
	}

}
