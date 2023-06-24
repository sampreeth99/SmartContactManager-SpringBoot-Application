package boot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.app.model.ContactManagerModel;

@Controller
@RequestMapping("/management")
public class ContactManagementController {
	

	@GetMapping("/add")
	public String showAddFormPage(@ModelAttribute("cd") ContactManagerModel t) {
		return "addForm";
	}

	
	
	
	

}
