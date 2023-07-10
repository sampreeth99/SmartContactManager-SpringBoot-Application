package boot.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boot.app.addcontact.service.IAddContactService;
import boot.app.contact.fileupload.FileUploadAddContactService;
import boot.app.entity.ContactDetails;
import boot.app.model.ContactManagerModel;

@Controller
@RequestMapping("/management")
public class ContactManagementController {
	
	@Autowired
	private IAddContactService addService;
	
	@Autowired
	private FileUploadAddContactService fileUpService;

	// Showing Add Contact Form Page to User
	@GetMapping("/add")
	public String showAddFormPage(@ModelAttribute("cd") ContactManagerModel t) {
		return "addForm";
	}
	
	@PostMapping("/save")
	public String saveContact(@ModelAttribute("cd") ContactManagerModel cd, Map<String, Object> map,RedirectAttributes r) {
		
		
		ContactDetails c = new ContactDetails();

		c.setCName(cd.getCName());
		c.setCNickName(cd.getCNickName());
		c.setCNo(cd.getCNo());
		c.setDest(cd.getDest());
		c.setAbout(cd.getAbout());

		String addResult=addService.saveContact(c);
		
		r.addFlashAttribute("addResult", addResult);
		fileUpService.uploadProfilePicToServerFolder(cd.getProfilePicMultiPart(), c);

		cd.setCName(null);
		cd.setCNickName(null);
		cd.setCNo(null);
		cd.setDest(null);
		cd.setAbout(null);

		return "redirect:add";
	}

	
	

	
	
	
	

}
