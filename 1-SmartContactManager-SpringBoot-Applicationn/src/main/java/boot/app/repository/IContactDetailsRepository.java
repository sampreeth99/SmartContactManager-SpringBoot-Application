package boot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import boot.app.entity.ContactDetails;

public interface IContactDetailsRepository extends JpaRepository<ContactDetails, Integer> {
	

	@Query(value = " select originalPicName from ContactDetails where cId=:id")
	public String getOName(Integer id);
	
	
	@Query(value = " select profilePicPath from ContactDetails where cId=:id")
	public String getPathById(Integer id);
	

}
