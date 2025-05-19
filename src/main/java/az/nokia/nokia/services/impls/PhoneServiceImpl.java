package az.nokia.nokia.services.impls;

import az.nokia.nokia.dtos.PhoneDto;
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

        return  phones.stream()
                .map(x -> modelMapper
                        .map(x, PhoneDto.class)).toList();

    }
}
