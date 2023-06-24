package boot.app.addcontact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.app.entity.ContactDetails;
import boot.app.repository.IContactDetailsRepository;

@Service
public class AddContactServiceIMPL implements IAddContactService {

	@Autowired
	private IContactDetailsRepository contactRepo;

	@Override
	public String saveContact(ContactDetails contactDetails) {
		ContactDetails cd = contactRepo.save(contactDetails);
		return "Contact Is Saved With Name" + " " + cd.getCName();
	}

}
