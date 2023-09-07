package boot.app.search.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.app.entity.ContactDetails;
import boot.app.repository.IContactDetailsRepository;

@Service
public class SearchServiceIMPL implements ContactManagerSearchService {

	@Autowired
	private IContactDetailsRepository repo;
	
	@Override
	public List<ContactDetails> searchContactByName(String name) {
		return repo.findBycNameContaining(name);
		
	}
}
