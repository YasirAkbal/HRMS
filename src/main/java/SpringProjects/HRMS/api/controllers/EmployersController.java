/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.EmployerService;
import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.dtos.EmployerWithCompanyIdNotCompany;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/employers")
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }
    
    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }
    
    @PostMapping("/addEmployerWithNewCompany")
    public Result addEmployerWithNewCompany(@RequestBody Employer employer) {
        return this.employerService.addEmployerWithNewCompany(employer);
    }
    
    @PostMapping("/addEmployerWithExistingCompany")
    public Result addEmployerWithExistingCompany(@RequestBody EmployerWithCompanyIdNotCompany employerDto) {
        return this.employerService.addEmployerWithExistingCompany(employerDto);
    }
}
