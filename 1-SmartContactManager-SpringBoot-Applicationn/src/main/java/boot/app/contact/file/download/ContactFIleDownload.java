package boot.app.contact.file.download;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.app.repository.IContactDetailsRepository;

@Service
public class ContactFIleDownload implements IContactFileDownloadService{
	
	@Autowired
	private IContactDetailsRepository repo;
	
	@Override
	public String oNameOfPic(Integer id) {
		
		String s=repo.getOName(id);
		
		System.out.println(s);
		return s;
	}
	

	@Override
	public String getPaths(Integer id) {
		return  repo.getPathById(id);
		
	}
	


	
	
	
	
	
}
	



