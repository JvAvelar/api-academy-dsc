package vitoravelar.academy.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vitoravelar.academy.dto.AcademyDTO;
import vitoravelar.academy.service.AcademyService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/academy")
@Validated
public class AcademyController {

    private final AcademyService academyService;

    public AcademyController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping
    public List<AcademyDTO> getAllAcademies() {
        return academyService.getAllAcademies();
    }

    @GetMapping("/id/{id}")
    public AcademyDTO getAcademyById(@PathVariable @Min(1) Long id) {
        return academyService.getAcademyById(id);
    }

    @GetMapping("/cnpj/{cnpj}")
    public AcademyDTO getAcademyByCnpj(@PathVariable String cnpj) {
        return academyService.getAcademyByCnpj(cnpj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcademyDTO addAcademy(@Valid @RequestBody AcademyDTO academyDTO) {
        return academyService.addAcademy(academyDTO);
    }

    @PutMapping("/{id}")
    public AcademyDTO updateAcademy(@PathVariable @Min(1) Long id, @Valid @RequestBody AcademyDTO academyDetails) {
        return academyService.updateAcademy(id, academyDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAcademy(@PathVariable @Min(1) Long id) {
        academyService.deleteAcademy(id);
    }
}