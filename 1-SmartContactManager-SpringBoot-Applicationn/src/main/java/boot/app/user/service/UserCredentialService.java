package boot.app.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import boot.app.entity.UserCredentials10;


public interface UserCredentialService extends UserDetailsService {

	public String saveUserCredentials(UserCredentials10 uc) ;
	
	
	
	
}
