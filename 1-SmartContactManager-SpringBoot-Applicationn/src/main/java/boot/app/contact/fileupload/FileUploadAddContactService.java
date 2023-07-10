package boot.app.contact.fileupload;

import org.springframework.web.multipart.MultipartFile;

import boot.app.entity.ContactDetails;
import boot.app.model.ContactManagerModel;

public interface FileUploadAddContactService {
	
	
	public Boolean uploadProfilePicToServerFolder(MultipartFile profile,ContactDetails contactDetails);
	
	
	

	

}
