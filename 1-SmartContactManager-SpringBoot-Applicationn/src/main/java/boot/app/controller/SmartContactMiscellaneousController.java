package boot.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contactManager")
public class SmartContactMiscellaneousController {
	

	@GetMapping("/")
	public String getIndex(Map<String, Object> map) {
		return "welcome";
	}
	
	@GetMapping("/update/profile")
	public String showChangeProfilePicForm(@RequestParam Integer uploadId, Map<String, Object> map) {
		map.put("uploadid", uploadId);
		return "changeProfile";
	}



}
