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
import javax.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getByIsActiveTrue() {
        return ResponseEntity.ok(jobAdvertisementService.getByIsActiveTrue());
    }

    @GetMapping("getOrderedByDateDesc")
    public ResponseEntity<DataResult<List<JobAdvertisement>>> getAllByOrderByCreateDateDesc() {
        return ResponseEntity.ok(jobAdvertisementService.getAllByOrderByCreateDateDesc());
    }

    @GetMapping("getByEmployer")
    public ResponseEntity<?> getByEmployer_EmployerId(@RequestParam long employerId) {
        DataResult<List<JobAdvertisement>> result = jobAdvertisementService.getByEmployer_EmployerId(employerId);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return ResponseEntity.ok(result);
    }

    @PostMapping("add")
    public ResponseEntity<?> addJobAdvertisement(@Valid @RequestBody JobAdvertisementCreateDto dto) {
        JobAdvertisement entity = jobAdvertisementMapper.convertToEntity(dto);
        
        Result result = jobAdvertisementService.addJobAdvertisement(entity);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("setActiveStatusFalse")
    public ResponseEntity<?> setActiveStatusFalse(@RequestParam long id) {
        Result result = jobAdvertisementService.setActiveStatusFalse(id);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return ResponseEntity.ok(result);
    }
}
