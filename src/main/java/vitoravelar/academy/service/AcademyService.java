package vitoravelar.academy.service;

import org.springframework.stereotype.Service;
import vitoravelar.academy.dto.AcademyDTO;
import vitoravelar.academy.exception.ResourceNotFoundException;
import vitoravelar.academy.models.Academy;
import vitoravelar.academy.repository.AcademyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademyService {

    private final AcademyRepository academyRepository;

    public AcademyService(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    public List<AcademyDTO> getAllAcademies() {
        return academyRepository.findAll().stream().map(Academy::toDTO).collect(Collectors.toList());
    }

    public AcademyDTO getAcademyById(Long id) {
        return academyRepository.findById(id)
                .map(Academy::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Academy not found with id: " + id));
    }

    public AcademyDTO getAcademyByCnpj(String cnpj) {
        return academyRepository.findByCnpj(cnpj)
                .map(Academy::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Academy not found with CNPJ: " + cnpj));
    }

    public AcademyDTO getAcademyByName(String name) {
        return academyRepository.findByName(name)
                .map(Academy::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Academy not found with Name: " + name));
    }

    public AcademyDTO addAcademy(AcademyDTO academyDTO) {
        Academy academy = new Academy();
        academy.setName(academyDTO.getName());
        academy.setCnpj(academyDTO.getCnpj());
        academy.setAddress(academyDTO.getAddress());
        academyRepository.save(academy);
        return academy.toDTO();
    }

    public AcademyDTO updateAcademy(Long id, AcademyDTO academyDetails) {
        Academy academy = academyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Academy not found with id: " + id));

        academy.setName(academyDetails.getName());
        academy.setAddress(academyDetails.getAddress());
        academyRepository.save(academy);
        return academy.toDTO();
    }

    public void deleteAcademy(Long id) {
        Academy academy = academyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Academy not found with id: " + id));
        academyRepository.delete(academy);
    }
}
