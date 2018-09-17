package com.example.Family.REST;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Family.Entities.Child;
import com.example.Family.Entities.Family;
import com.example.Family.Entities.Father;
import com.example.Family.Repository.ChildRepository;
import com.example.Family.Repository.FamilyRepository;
import com.example.Family.Repository.FatherRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RESTController {
	
	private final ChildRepository childRepository;
	private final FamilyRepository familyRepository;
	private final FatherRepository fatherRepository;

	@Autowired
	public RESTController(ChildRepository childRepository, FamilyRepository familyRepository,
			FatherRepository fatherRepository) {
		super();
		this.childRepository = childRepository;
		this.familyRepository = familyRepository;
		this.fatherRepository = fatherRepository;
	}

	@GetMapping("/getChildren")
	public @ResponseBody List<Child> getAllChildren(){
		return childRepository.findAllChild();
	}
	
	@GetMapping("/getFathers")
	public @ResponseBody List<Father> getAllFathers(){
		return fatherRepository.findAllFathers();
	}
	
	@GetMapping("/getFamilyByBirthDateChild/{dateChild}")
	public @ResponseBody List<Family> getFamilyByBirthDateChild(@PathVariable("dateChild") String dateChild) throws ParseException{
		return familyRepository.getFamilyByBirthDateChild(dateChild);
	}
	
	@GetMapping("/getFamilyByPeselChild/{pesel}")
	public @ResponseBody List<Family> getFamilyByPeselChild(@PathVariable("pesel") String pesel){
		return familyRepository.getFamilyByPeselChild(pesel);
	}
	
	@GetMapping("/getFamilyBySexChild/{sex}")
	public @ResponseBody List<Family> getFamilyBySexChild(@PathVariable("sex") String sex){
		return familyRepository.getFamilyBySexChild(sex);
	}
	
	@GetMapping("/getFamilyByFirstNameChild/{firstName}")
	public @ResponseBody List<Family> getFamilyByFirstNameChild(@PathVariable("firstName") String firstName){
		return familyRepository.getFamilyByNameChild(firstName);
	}
	
	@GetMapping("/getFamilyBySecondNameChild/{secondName}")
	public @ResponseBody List<Family> getFamilyBySecondNameChild(@PathVariable("secondName") String secondName){
		return familyRepository.getFamilyBySecondNameChild(secondName);
	}
	
	
	
	@GetMapping("/getFamilies")
	public @ResponseBody List<Family> getAllFamilies(){
		return familyRepository.findAllFamilies();
	}
	
	
	@PostMapping("/addFamily")
	public Family addFamily(@RequestBody Family family){
		return familyRepository.addFamily(family);
	}

}
