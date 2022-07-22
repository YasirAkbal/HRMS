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
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }
    
    @GetMapping("/getAllWithCompanyId")
    public DataResult<List<EmployerGetWithCompanyIdDto>> getAllWithCompanyId() {
        DataResult<List<Employer>> result = this.employerService.getAll();
        if(!result.isSuccess())
            return new ErrorDataResult<>(result.getMessage());
        
        return new SuccessDataResult<>(this.employerGetWithCompanyIdMapper.convertToDto(result.getData()));
    }
    
    @PostMapping("/addEmployerWithNewCompany")
    public Result addEmployerWithNewCompany(@RequestBody Employer employer) {
        return this.employerService.addEmployerWithNewCompany(employer);
    }
    
    @PostMapping("/addEmployerWithExistingCompany")
    public Result addEmployerWithExistingCompany(@RequestBody EmployerCreateWithExistingCompanyDto employerDto) {
        Employer employer = employerCreateWithExistingCompanyMapper.convertToEntity(employerDto);
        return this.employerService.addEmployerWithExistingCompany(employer);
    }
}
