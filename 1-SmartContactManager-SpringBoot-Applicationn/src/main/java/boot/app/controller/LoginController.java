package boot.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	

	@RequestMapping("/showlogin")
	public String showLogin(Principal principal) {
		
		return "login";
	}

}
