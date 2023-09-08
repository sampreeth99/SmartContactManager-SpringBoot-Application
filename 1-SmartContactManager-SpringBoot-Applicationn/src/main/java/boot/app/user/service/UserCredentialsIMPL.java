package boot.app.user.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import boot.app.entity.UserCredentials10;
import boot.app.user.repo.UserCredentialsRepository;

@Service
public class UserCredentialsIMPL implements UserCredentialService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private UserCredentialsRepository userRepo;
	
	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserCredentials10 u=userRepo.findByuName(username);
		System.out.println("from service raw"+u);
		
		
		
		Set<String> roles=u.getRoles();
		
			Set<GrantedAuthority> gr=new HashSet<GrantedAuthority>();
         roles.forEach(role -> {
        	 GrantedAuthority g=new SimpleGrantedAuthority(role);
 			gr.add(g);
         });
          
          UserDetails user=new User(u.getUName(), u.getPwd(),gr );
		

  		System.out.println("from service"+user);
		
		return user;
	}
	
	@Override
	public String saveUserCredentials(UserCredentials10 uc) {
		
		String p=uc.getPwd();
		
		String encodedPass=bCryptPasswordEncoder.encode(p);
		
		uc.setPwd(encodedPass);
		
		UserCredentials10 c=userRepo.save(uc);
		
		String fMsg="User Registration Failed";
		
		
		if (c==null) 
			return fMsg;
	
		
		return "User Registered Succesfully";
			
		
		
	}

}
