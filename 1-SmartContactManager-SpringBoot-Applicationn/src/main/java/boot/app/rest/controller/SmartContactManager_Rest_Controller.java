package boot.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.app.entity.ContactDetails;
import boot.app.search.search.ContactManagerSearchService;

@RestController
@RequestMapping("/api")
public class SmartContactManager_Rest_Controller {
	
	@Autowired
	private ContactManagerSearchService searchService;
	
	


	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<ContactDetails>> searchContactsByName(@PathVariable("name")  String name){
		List<ContactDetails> l=searchService.searchContactByName(name);
		
		return new ResponseEntity<List<ContactDetails>>(l,HttpStatus.OK);
	}

}
