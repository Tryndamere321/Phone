package az.nokia.nokia.services.impls;

import az.nokia.nokia.dtos.phoneDtos.PhoneCreateDto;
import az.nokia.nokia.dtos.phoneDtos.PhoneDto;
import az.nokia.nokia.dtos.phoneDtos.PhoneUpdateDto;
import az.nokia.nokia.models.Phone;
import az.nokia.nokia.repository.PhoneRepository;
import az.nokia.nokia.services.PhoneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final ModelMapper modelMapper;

    public PhoneServiceImpl(PhoneRepository phoneRepository, ModelMapper modelMapper) {
        this.phoneRepository = phoneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PhoneDto> getAllPhones() {
        List<Phone> phones = phoneRepository.findAll();

        return phones.stream()
                .map(x -> modelMapper
                        .map(x, PhoneDto.class)).toList();

    }

    @Override
    public PhoneUpdateDto findUpdatePhone(Long id) {
        Phone findPhone = phoneRepository.findById(id).orElseThrow();
        return modelMapper.map(findPhone, PhoneUpdateDto.class);
    }

    @Override
    public boolean createPhone(PhoneCreateDto phoneCreateDto) {
        Phone findPhone = phoneRepository.findByName(phoneCreateDto.getName());
        if (findPhone != null) {
            return false;
        }
        try {
            Phone phone = new Phone();
            phone.setName(phoneCreateDto.getName());
            phone.setPrice(phoneCreateDto.getPrice());
            phoneRepository.save(phone);
            return true;

        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public boolean updatePhone(PhoneUpdateDto phoneUpdateDto, Long id) {
        Phone findPhone = phoneRepository.findById(id).orElseThrow();
        try {
            findPhone.setName(phoneUpdateDto.getName());
            findPhone.setPrice(phoneUpdateDto.getPrice());
            phoneRepository.save(findPhone);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}
