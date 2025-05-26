package az.nokia.nokia.services;

import az.nokia.nokia.dtos.phoneDtos.PhoneCreateDto;
import az.nokia.nokia.dtos.phoneDtos.PhoneDto;
import az.nokia.nokia.dtos.phoneDtos.PhoneUpdateDto;

import java.util.List;

public interface PhoneService {
    List<PhoneDto> getAllPhones();
    PhoneUpdateDto findUpdatePhone(Long id);
    boolean createPhone(PhoneCreateDto phoneCreateDto);
    boolean updatePhone(PhoneUpdateDto phoneUpdateDto,Long id);
    void deletePhone(Long id);

}
