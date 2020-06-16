package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.DonateDto;
import com.example.demo.dtos.PaymentDto;
import com.example.demo.dtos.PaymentResponseDto;
import com.example.demo.entity.Payment;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("api/v4")
public class PaymentController {
	  @Autowired
		PaymentRepository paymentRepoo;
		

		
		@Autowired
		PaymentService paymentService;
		/***************************list of Donation *****************************/

//		 @GetMapping("/donation")
//		    public List<Donate> getAllDonation() {
//			 
//		        return donateRepoo.findAll();
//		    }
//		    @GetMapping("/donation")
//		    public Donate getAllDonationbyIDchild(@PathVariable Integer idchild ) {
//			 
//		        return null;//donateRepoo.findByIdchild(idchild);
//		    }
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
		  
//			 @RequestMapping(value = "/payment", method = RequestMethod.POST)
//			    public PaymentDto createPayment(@Valid @RequestBody PaymentDto paymentDto) {
//				 return paymentService.savePayment(paymentDto);
//				 
//			    }
			 
			 @PostMapping("/payment")
			 public String testSave(@RequestBody PaymentDto paymentDto) {
				 return paymentService.savePayment(paymentDto);
			 }
			 
			@GetMapping("/getAll")
			public List<PaymentResponseDto> getAllPayment(){
				return paymentService.getAllPayment();
			}
		
}
