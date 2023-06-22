package boot.app.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "CONTACT_DETAILS")
@Setter
@Getter
@ToString
public class ContactDetails implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cId;

	@Column(length = 20)
	//@NotEmpty
	private String cName;
	
	@Column(length = 20)
	private String cNickName;
	
	//@NotNull
	private Long cNo;
	
	@Column(length = 20)
	private String dest;
	
	@Column(length = 80)
	private String about;
	
	@Column(length = 200)
	private String profilePicPath;
	

	@Column(length =100)
	private String originalPicName;

	


}
