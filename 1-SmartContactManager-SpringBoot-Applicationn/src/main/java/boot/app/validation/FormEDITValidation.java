package boot.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import boot.app.entity.ContactDetails;

@Component("validEdit")
public class FormEDITValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ContactDetails.class);

	}
	
	@Override
	public void validate(Object target, Errors errors) {

		ContactDetails cm = (ContactDetails) target;
		System.out.println("from validator==" + cm);

		// cName Blank or empty checking

		if (cm.getCName().isEmpty() || cm.getCName().isBlank()) {
			errors.rejectValue("cName", "sname.required");
		}

		// cName Length checking
		else if (cm.getCName().length() < 5 || cm.getCName().length() > 15) {
			errors.rejectValue("cName", "sname.length");
		}

		// ===================Nick Name Validation Length=================

		String nickName = cm.getCNickName();
		if (!nickName.isEmpty() || !nickName.isBlank()) {

			int len = nickName.length();

			if (len < 5 || len > 10) {
				errors.rejectValue("cNickName", "nick.length");
			}

		}

		/*
		 * 
		 * //cName Length checking if(cm.getCNickName().length()<4 ||
		 * cm.getCNickName().length()>10) { errors.rejectValue("cNickName",
		 * "contact.nickname.length"); }
		 */

		// VALIDATION FOR CNO NULL
		if (cm.getCNo() == null) {
			errors.rejectValue("cNo", "percent.required");
		}

		/*
		 * VALIDATION FOR CNO LENGTH else if(cm.getCNo()!= ) { errors.rejectValue("cNo",
		 * "percentage.length"); }
		 */

		/*
		 * // validation for job if(emp.getAddrs().isBlank()) {
		 * errors.rejectValue("addrs", "addrs.required"); } else
		 * if(emp.getAddrs().length()<5 || emp.getAddrs().length()>10) {
		 * errors.rejectValue("addrs", "addrs.length"); }
		 */

		// ================Contact Destination Validation=========================

		if (cm.getDest().isEmpty() || cm.getDest().isBlank()) {
			errors.rejectValue("dest", "dest.required");
		}

		// dest Length checking
		else if (cm.getDest().length() < 3 || cm.getDest().length() > 15) {
			errors.rejectValue("dest", "dest.length");
		}

		// ================About Validation=========================

		if (cm.getAbout().isEmpty() || cm.getAbout().isBlank()) {
			errors.rejectValue("about", "about.required");
		}

		/*
		 * //dest Length checking if(cm.getDest().length()<30 ||
		 * cm.getDest().length()>100) { errors.rejectValue("about", "about.length");
		 * 
		 * }
		 */
}
}