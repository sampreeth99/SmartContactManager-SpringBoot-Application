package boot.app.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ContactManagerModel implements Serializable {

	private String cName;

	private String cNickName;

	private Long cNo;

	private String dest;

	private String about;

	private MultipartFile profilePicMultiPart;

}
