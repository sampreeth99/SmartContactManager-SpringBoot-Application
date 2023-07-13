package boot.app.EditContact.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.app.entity.ContactDetails;
import boot.app.repository.IContactDetailsRepository;

@Service
public class EditContactServiceIMPL implements IEditContactService {
	
	@Autowired
	private IContactDetailsRepository conRepo;

	@Override
	public String editContactById(ContactDetails c) {
		Optional<ContactDetails> op=conRepo.findById(c.getCId());
		if (op.isPresent()) {
			conRepo.save(c);
			return c.getCName()+" "+"is Updated Succesfully";
			
		}
		else {
			 return "Contact Not Found";
		}
		

	}

}
