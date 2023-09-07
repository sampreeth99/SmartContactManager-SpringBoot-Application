package boot.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.app.ShowContact.service.IShowContactService;
import boot.app.addcontact.service.IAddContactService;
import boot.app.contact.file.download.IContactFileDownloadService;
import boot.app.contact.fileupload.FileUploadAddContactService;
import boot.app.entity.ContactDetails;
import boot.app.model.ContactManagerModel;
import boot.app.validation.FormADDValidation;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/management")
public class ContactManagementController {
	
	@Autowired
	private IAddContactService addService;
	
	@Autowired
	private FileUploadAddContactService fileUpService;
	
	@Autowired
	private IShowContactService showService;
	
	@Autowired
	private IContactFileDownloadService downService;
	
	
	
	

	
	@Autowired
	private FormADDValidation valid;
	
	
	// Showing Add Contact Form Page to User
	@GetMapping("/add")
	public String showAddFormPage(@ModelAttribute("cd") ContactManagerModel t) {
		return "addForm";
	}
	
	@PostMapping("/save")
	public String saveContact(@ModelAttribute("cd") ContactManagerModel cd, Map<String, Object> map,
			BindingResult errors) {
		
		if (valid.supports(ContactManagerModel.class)) {
			valid.validate(cd, errors);

			if (errors.hasErrors()) {

				return "addForm";
			}

		}

		ContactDetails c = new ContactDetails();

		c.setCName(cd.getCName());
		c.setCNickName(cd.getCNickName());
		c.setCNo(cd.getCNo());
		c.setDest(cd.getDest());
		c.setAbout(cd.getAbout());

		addService.saveContact(c);
		
		fileUpService.uploadProfilePicToServerFolder(cd.getProfilePicMultiPart(), c);

		cd.setCName(null);
		cd.setCNickName(null);
		cd.setCNo(null);
		cd.setDest(null);
		cd.setAbout(null);

		return "addForm";
	}
	
	

	@GetMapping("/showAllContactsByPage")
	public String showContactsbypagination(
			@PageableDefault(page = 0, size = 5) org.springframework.data.domain.Pageable p, Map<String, Object> map) {
		Page<ContactDetails> page = showService.showAllContacts(p);

		map.put("allContactList", page.getContent());
		map.put("totalPages", page.getTotalPages());
		map.put("currPageNo", page.getNumber());
		map.put("next", page.hasNext());

		return "ShowContacts";
	}
	
	
	@GetMapping("/moreContactInfo")
	public String moreInfo(@RequestParam Integer cid, Map<String, Object> map) {

		ContactDetails d = showService.getAllContactDetailsById(cid);
		map.put("contact", d);
		
		String name = downService.oNameOfPic(cid);
		map.put("pic", name);
		

		return "moreInfo";
	}
	
	@GetMapping("/download")
	public String downloadImage(@RequestParam Integer id, HttpServletResponse res, HttpServletRequest req)
			throws IOException {

		String pathName = downService.getPaths(id);
		System.out.println(pathName);
		File f = new File(pathName);
		ServletContext sc = req.getServletContext();
		try {
			FileInputStream fi = new FileInputStream(f);
			long len = f.length();
			ServletOutputStream s = res.getOutputStream();
			res.setContentLengthLong(len);
			String mime = sc.getMimeType("f");
			// mime=mime==null?"application/octet-stream":mime;
			res.setContentType(mime);
			System.out.println(mime);
			res.setHeader("Content-Disposition", "attachment;filename=" + f.getName());
			IOUtils.copy(fi, s);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return null;
	}


	
	


	
	
	
	
	

}
