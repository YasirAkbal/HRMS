/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.JobAdvertisementService;
import SpringProjects.HRMS.entities.concretes.JobAdvertisement;
import SpringProjects.HRMS.entities.concretes.JobPosition;
import SpringProjects.HRMS.entities.dtos.JobAdvertisementCreateDto;
import SpringProjects.HRMS.entities.mappers.JobAdvertisementMapper;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/jobadvertisements/")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;
    private JobAdvertisementMapper jobAdvertisementMapper = Mappers.getMapper(JobAdvertisementMapper.class);
    
    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) { 
        this.jobAdvertisementService = jobAdvertisementService;
    }
    
    @GetMapping("getActives")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
        return jobAdvertisementService.getByIsActiveTrue();
    }

    @GetMapping("getOrderedByDateDesc")
    public DataResult<List<JobAdvertisement>> getAllByOrderByCreateDateDesc() {
        return jobAdvertisementService.getAllByOrderByCreateDateDesc();
    }

    @GetMapping("getByEmployer")
    public DataResult<List<JobAdvertisement>> getByEmployer_EmployerId(@RequestParam long employerId) {
        return jobAdvertisementService.getByEmployer_EmployerId(employerId);
    }

    @PostMapping("add")
    public Result addJobAdvertisement(@RequestBody JobAdvertisementCreateDto dto) {
        JobAdvertisement entity = jobAdvertisementMapper.convertToEntity(dto);
        return jobAdvertisementService.addJobAdvertisement(entity);
    }
    
    @GetMapping("setActiveStatusFalse")
    public Result setActiveStatusFalse(@RequestParam long id) {
        return jobAdvertisementService.setActiveStatusFalse(id);
    }
}
