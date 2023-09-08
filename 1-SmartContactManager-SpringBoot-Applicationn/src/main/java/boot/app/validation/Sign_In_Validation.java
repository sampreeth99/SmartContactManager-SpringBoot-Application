package boot.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import boot.app.entity.UserCredentials10;

@Component("Signvalid")
public class Sign_In_Validation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCredentials10.class);

	}

	@Override
	public void validate(Object target, Errors errors) {

		UserCredentials10 cm = (UserCredentials10) target;
		System.out.println("from validator==" + cm);

		// cName Blank or empty checking

		if (cm.getUName().isEmpty() || cm.getUName().isBlank()) {
			errors.rejectValue("uName", "uname.required");
		}

		// cName Length checking
		else if (cm.getUName().length() < 5 || cm.getUName().length() > 15) {
			errors.rejectValue("uName", "uname.length");
		}

		// ===================Password Validation Length=================

		if (cm.getPwd().isEmpty() || cm.getPwd().isBlank()) {
			errors.rejectValue("pwd", "pwd.required");
		}

		
		String nickName = cm.getPwd();
		
		
		if (!nickName.isEmpty() || !nickName.isBlank()) {

			int len = nickName.length();

			if (len < 5 || len > 10) {
				errors.rejectValue("pwd", "pwd.length");
			}

		}
		
		
		if (cm.getRoles().size()==0) {
			errors.rejectValue("roles","role.required");
		}

				
		
		
		

	}
}