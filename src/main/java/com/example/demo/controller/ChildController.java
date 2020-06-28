package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;
import com.example.demo.entity.Donate;
import com.example.demo.service.ChildService;
import com.example.demo.service.DonateService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.AppResultDto;
import com.example.demo.dtos.ChildDto;
import com.example.demo.dtos.DonateDto;
import com.example.demo.entity.Child;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.DonateRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class ChildController {
	@Autowired
    private	ChildRepository childRepoo;
	@Autowired
	private ModelMapper modelMapper;
    @Autowired
    private DonateService donateService;
    @Autowired
    private ChildService childService;
    @Autowired
    private DonateRepository donateRepository;
	      /********************list of child ***********************/
	
	 @GetMapping("/child")
	    public List<Child> getAllChild() {
	        return childRepoo.findAll();
	    }
 
          /*******************list of child by id ***************************/
	 
	  @GetMapping("/child/{id}")
	    public ResponseEntity<Child> getChildById(@PathVariable(value = "id") Integer idchild)
	        throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	          .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));
	        return ResponseEntity.ok().body(child);
	    }
	      /*************************** create of child *************************************/
	  
	/* @RequestMapping(value = "/child", method = RequestMethod.POST)
	    public Child createChild(@Valid @RequestBody Child child) {
	        return childRepoo.save(child);
	    }*/
	  @RequestMapping(value = "/child", method = RequestMethod.POST)
	    public AppResultDto createChild(@Valid @RequestBody ChildDto childDto) {
		 childService.saveChild(childDto);
		 return new AppResultDto();
	    }
	    
	        /*******************update of child ***********************/
	 
	 @RequestMapping(value = "/child/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Child> updateChild(@PathVariable(value = "id") Integer idchild,
	         @Valid @RequestBody Child childDetails) throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	        .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));

	        child = modelMapper.map(childDetails,Child.class);
	        final Child updatedChild = childRepoo.save(child);
	        return ResponseEntity.ok(updatedChild);
	    }
	       /*******************Delete of child******************************/
	 
	    @RequestMapping(value = "/child/{id}", method = RequestMethod.DELETE)
	    public Map<String, Boolean> deleteChild(@PathVariable(value = "id") Integer idchild)
	         throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	       .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));

	        childRepoo.delete(child);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
	    // add a donator to spicefic child 
	   /* @RequestMapping(value = "/child/addDonator/{childId}", method = RequestMethod.POST)
	    public Map<String, Boolean> addDonator(@PathVariable(value = "childId") Integer idchild,@RequestBody DonateDto d)
	         throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	       .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));

	        // donate :: dto
	        // child.addDonator
	        //donate = donateService.getByEmail(d.getDonatoremail());
	        //child.setDonate(donate);
	        //save child .
	    }*/
	    // add a donator to spicefic child
	   /* @RequestMapping(value = "/child/addDonator/{childId}", method = RequestMethod.POST)
	    public Child addDonator(@PathVariable(value = "childId") Integer idchild, @RequestBody DonateDto d)
	            throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	                .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));

	        Donate donate = donateService.getDonateById(d.getId());
	        child.setDonate(donate);
	        return childRepoo.save(child);
	    }
*/
	    @RequestMapping(value = "/child/unAssignedChildren", method = RequestMethod.GET)
	    public List<Child> getListChildWithNoDonator() {
	      //  return this.childRepoo.findAllByDonateIsNull();
	    	 return childRepoo.findAll();
	    }

	   @PutMapping("/child/{id}/donate")
	  @Transactional
	  public ResponseEntity<?> donateToChild(@PathVariable Integer id,@Valid @RequestBody Donate donate) throws ResourceNotFoundException
	    {
	    	Child child=this.childRepoo.findById(id)
	    			.orElseThrow(()->new ResourceNotFoundException("child not found"));
	    	
	    	Donate savedDonate=this.donateRepository.save(donate);
	    	//donate.set
	    	//child.setDonate(savedDonate);
	    
	    	//child.getDonate().add(savedDonate);
	    	return ResponseEntity.ok(child);
	    			
	    }
}
