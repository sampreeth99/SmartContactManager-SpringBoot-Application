package boot.app.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.app.entity.UserCredentials10;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials10, Integer> {
	
	public UserCredentials10 findByuName(String uname);

}
