package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.DonateDto;
import com.example.demo.entity.Child;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ChildRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildController {
	@Autowired
    private	ChildRepository childRepoo;
	@Autowired
	private ModelMapper modelMapper;
	      /********************list of child ***********************/
	
	 @GetMapping("/child")
	    public List<Child> getAllChild() {
	        return childRepoo.findAll();
	    }
 
          /*******************list of child by id ***************************/
	 
	  @GetMapping("/child/{id}")
	    public ResponseEntity<Child> getEmployeeById(@PathVariable(value = "id") Integer idchild)
	        throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	          .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));
	        return ResponseEntity.ok().body(child);
	    }
	      /*************************** create of child *************************************/
	  
	 @RequestMapping(value = "/child", method = RequestMethod.POST)
	    public Child createChild(@Valid @RequestBody Child child) {
	        return childRepoo.save(child);
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
	    @RequestMapping(value = "/child/addDonator/{childId}", method = RequestMethod.POST)
	    public Map<String, Boolean> addDonator(@PathVariable(value = "childId") Integer idchild,@RequestBody DonateDto d)
	         throws ResourceNotFoundException {
	        Child child = childRepoo.findById(idchild)
	       .orElseThrow(() -> new ResourceNotFoundException("Child not found for this id :: " + idchild));

	        // donate :: dto
	        // child.addDonator
	        donate = donateService.getByEmail(d.getDonatoremail());
	        child.setDonate(donate);
	        save child .
	    }

}
