/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.EmployerService;
import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.dtos.EmployerCreateWithExistingCompanyDto;
import SpringProjects.HRMS.entities.dtos.EmployerGetWithCompanyIdDto;
import SpringProjects.HRMS.entities.mappers.EmployerCreateWithExistingCompanyMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;
import SpringProjects.HRMS.entities.mappers.EmployerGetWithCompanyIdMapper;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springprojects.HRMS.core.utilities.results.ErrorDataResult;

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/employers")
public class EmployersController {
    private EmployerService employerService;
    private EmployerGetWithCompanyIdMapper employerGetWithCompanyIdMapper = Mappers.getMapper(EmployerGetWithCompanyIdMapper.class);
    private EmployerCreateWithExistingCompanyMapper employerCreateWithExistingCompanyMapper = Mappers.getMapper(EmployerCreateWithExistingCompanyMapper.class);

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        DataResult<List<Employer>> result = this.employerService.getAll();
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/getAllWithCompanyId")
    public ResponseEntity<DataResult<List<EmployerGetWithCompanyIdDto>>> getAllWithCompanyId() {
        DataResult<List<Employer>> result = this.employerService.getAll();
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(new ErrorDataResult<>(result.getMessage()));
        
        return ResponseEntity.ok(new SuccessDataResult<>(this.employerGetWithCompanyIdMapper.convertToDto(result.getData())));
    }
    
    @PostMapping("/addEmployerWithNewCompany")
    public ResponseEntity<?> addEmployerWithNewCompany(@Valid @RequestBody Employer employer) {
        Result result = this.employerService.addEmployerWithNewCompany(employer);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @PostMapping("/addEmployerWithExistingCompany")
    public ResponseEntity<?> addEmployerWithExistingCompany(@Valid @RequestBody EmployerCreateWithExistingCompanyDto employerDto) {
        Employer employer = employerCreateWithExistingCompanyMapper.convertToEntity(employerDto);
        
        Result result = this.employerService.addEmployerWithExistingCompany(employer);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
