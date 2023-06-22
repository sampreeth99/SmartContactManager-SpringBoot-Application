package boot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.app.entity.ContactDetails;

public interface IContactDetailsRepository extends JpaRepository<ContactDetails, Integer> {

}
