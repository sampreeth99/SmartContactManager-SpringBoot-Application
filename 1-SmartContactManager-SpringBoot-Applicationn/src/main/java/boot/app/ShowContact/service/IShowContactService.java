package boot.app.ShowContact.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import boot.app.entity.ContactDetails;

public interface IShowContactService {

	//Showing All Contacts Partially
	public Page<ContactDetails> showAllContacts(Pageable pageable);
	
	//Showing Contact Details By Clicking on More Hyperlink
	public ContactDetails getAllContactDetailsById(Integer id) ;
	
	public List<ContactDetails> showAllCon();
	
	

}
