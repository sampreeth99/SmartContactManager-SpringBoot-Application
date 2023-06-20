package boot.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contactManager")
public class SmartContactMiscellaneousController {
	

	@GetMapping("/")
	public String getIndex(Map<String, Object> map) {
		return "pages/welcome";
	}


}
