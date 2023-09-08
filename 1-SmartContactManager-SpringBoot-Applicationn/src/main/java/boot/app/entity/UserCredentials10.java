package boot.app.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="UserSecurity")
@Setter
@Getter
@ToString

public class UserCredentials10 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer unId;

	@Column(length = 20,unique = true)
	private String uName;
	
	@Column(length = 100)
	private String pwd;
	
	//@NotNull
	private boolean status=true;
	
	@ElementCollection
	@CollectionTable(name = "security_roles10",joinColumns = @JoinColumn(referencedColumnName = "unId",name = "f_uid"))
	@Column(name = "user_security_role")
	private Set<String> roles;
	
	}
