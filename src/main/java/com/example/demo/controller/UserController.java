package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Child;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
    UserService service;
	@Autowired
    UserRepository userRepoo;
	 /************************* Register for user in a system*************************/
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmail();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			User userobj=service.fetchUserByEmail(tempEmailId);
			if( userobj!=null) {
				throw new Exception("user with "+tempEmailId+"is already existe");
			}
		}
	user = service.saveUser(user);
		return user;
	}
	  /********************** login for user in a system *****************************/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmail();
		String tempPass=user.getPassword();
		User userobj=null;
		if(tempEmailId!=null && tempPass!=null) {
			userobj=service.fetchUserByEmailAndPassword(tempEmailId, tempPass);
		}
		if( userobj==null) {
			throw new Exception("Bad credentials");
		}
		return userobj;
	}
	//System.out.println(user);

    /***************************list of users ********************************/

        @GetMapping("/users")
         public List<User> getAllUsers() {
             return userRepoo.findAll();
              }
    /***************************list of users by id ********************************/
        @GetMapping("/users/{id}")
	    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") Integer iduser)
	        throws ResourceNotFoundException {
	        User user = userRepoo.findById(iduser)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + iduser));
	        return ResponseEntity.ok().body(user);
	    }
        
        /*******************update of user ***********************/
 
 @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer iduser,
         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepoo.findById(iduser)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + iduser));

       // child.setEmailId(childeDetails.getEmailId());
        user.setEmail(userDetails.getEmail());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
      
        final User updatedUser = userRepoo.save(user);
        return ResponseEntity.ok(updatedUser);
    }
 /*******************Delete of child******************************/
 
      @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
       public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer iduser)
          throws ResourceNotFoundException {
         User user = userRepoo.findById(iduser)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + iduser));

         userRepoo.delete(user);
         Map<String, Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
          return response;
     }
}
