package boot.app.validation;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import boot.app.entity.ContactDetails;
import boot.app.model.ContactManagerModel;

@Component("valid")
public class FormADDValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ContactManagerModel.class);

	}

	@Override
	public void validate(Object target, Errors errors) {

		ContactManagerModel cm = (ContactManagerModel) target;
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
		
		MultipartFile file=cm.getProfilePicMultiPart();
		long s=file.getSize();
		System.out.println(s);

		if (s>0) {
			
			if (s>10485760) {
				errors.rejectValue("profilePicMultiPart", "file.length");
				
			}
			
				
			
			
			
		}
		
		
		
		

	}
}