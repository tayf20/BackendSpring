package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.AppResultDto;
import com.example.demo.dtos.DonateDto;
import com.example.demo.entity.Donate;
import com.example.demo.repository.DonateRepository;
import com.example.demo.service.DonateService;

@RestController
@RequestMapping("/api/v3")
public class DonateController {
    @Autowired
	DonateRepository donateRepoo;
	

	
	@Autowired
	DonateService donateService;
	
	/***************************list of Donation *****************************/

	 @GetMapping("/donation")
	    public List<Donate> getAllDonation() {
		 
        return donateRepoo.findAll();
   }
//	    @GetMapping("/donation")
//	    public Donate getAllDonationbyIDchild(@PathVariable Integer idchild ) {
//		 
//	        return null;//donateRepoo.findByIdchild(idchild);
//	    }
	  /*******************list of donation by id ***************************/
	 
	//  @GetMapping("/donation/{id}")
   //  public ResponseEntity<Donate> getDonateById(@PathVariable(value = "id") Integer iddonate)
      //  throws ResourceNotFoundException {
	 // Donate donate = donateRepoo.findById(iddonate)
	     //     .orElseThrow(() -> new ResourceNotFoundException("Donate not found for this id :: " + iddonate));
	       // return ResponseEntity.ok().body(donate);
	   // }
	

   /*  @GetMapping("/donation/{id}")
       public ResponseEntity<DonateDto> getDonateById(@PathVariable(value = "id") Integer iddonate)
          throws ResourceNotFoundException {
    	 DonateDto donateDto = donateService.getDonateById(iddonate)
	    .orElseThrow(() -> new ResourceNotFoundException("Donate not found for this id :: " + iddonate));
        return ResponseEntity.ok().body(donateDto);
 }*/
	  /*************************** create of donate *************************************/
	  
		 @RequestMapping(value = "/donation", method = RequestMethod.POST)
		    public AppResultDto createDonate(@Valid @RequestBody DonateDto donateDto) {
			 donateService.saveDonate(donateDto);
			 return new AppResultDto();
		    }
		 @RequestMapping(value = "/donator", method = RequestMethod.POST)
		    public Donate createChild(@Valid @RequestBody Donate donate) {
		        return donateRepoo.save(donate);
		    }
	
		    
}
