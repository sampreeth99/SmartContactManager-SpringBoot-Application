package boot.app.contact.fileupload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import boot.app.entity.ContactDetails;
import boot.app.repository.IContactDetailsRepository;

@Service
public class FileUploadIMPLService implements FileUploadAddContactService {
	
	@Autowired
	private IContactDetailsRepository repo;
	
		@Override
	public Boolean uploadProfilePicToServerFolder(MultipartFile profile, ContactDetails contactDetails) {
		String oName=profile.getOriginalFilename();
		String cName=null;
	 
		
	   boolean uploaded=false;
		try {
			String destf="C:\\Users\\sampreeth\\git\\SmartContactManager-SpringBoot-Application\\1-SmartContactManager-SpringBoot-Applicationn\\src\\main\\webapp\\images";
			Files.copy(profile.getInputStream(),Paths.get(destf+File.separator+oName),StandardCopyOption.REPLACE_EXISTING);
			uploaded=true;
			contactDetails.setProfilePicPath(Paths.get(destf+File.separator+oName).toString());
			contactDetails.setOriginalPicName(oName);
			repo.save(contactDetails);
			System.out.println("from upload service::"+contactDetails);
			uploaded=true;
			} catch (IOException e) {
			e.printStackTrace();
		}
			return uploaded;
	}
}
