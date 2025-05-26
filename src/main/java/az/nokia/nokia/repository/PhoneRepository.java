package az.nokia.nokia.repository;

import az.nokia.nokia.dtos.phoneDtos.PhoneUpdateDto;
import az.nokia.nokia.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
    Phone findByName(String name);
}
