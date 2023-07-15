
package boot.app.DeleteContact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.app.repository.IContactDetailsRepository;

@Service
public class DeleteServiceIMPL implements IDeleteContactService {
	
	@Autowired
	private IContactDetailsRepository conRepo;

	@Override
	public String removeById(Integer id) {
		conRepo.deleteById(id);
		return "Contact Deleted Succesfully by Id"+id;
	}

}
