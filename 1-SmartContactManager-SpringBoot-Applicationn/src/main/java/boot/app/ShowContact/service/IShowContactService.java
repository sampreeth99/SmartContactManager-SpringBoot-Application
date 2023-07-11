package boot.app.ShowContact.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import boot.app.entity.ContactDetails;

public interface IShowContactService {
	
	
	
	public Page<ContactDetails> showAllContacts(Pageable pageable);

}
