package boot.app.ShowContact.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import boot.app.entity.ContactDetails;
import boot.app.repository.IContactDetailsRepository;

@Service
public class ShowContactServiceIMPL implements IShowContactService {

	@Autowired
	private IContactDetailsRepository conRepo;

	@Override
	public Page<ContactDetails> showAllContacts(Pageable pageable) {

		return conRepo.findAll(pageable);
	}
	
	
	ContactDetails d = null;

	@Override
	public ContactDetails getAllContactDetailsById(Integer id) {
		Optional<ContactDetails> op = conRepo.findById(id);
		if (op.isPresent()) {
			d = op.get();
		}

		return d;
	
	}

}
