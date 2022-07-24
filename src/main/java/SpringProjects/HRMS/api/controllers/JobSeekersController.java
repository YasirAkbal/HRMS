/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.JobSeekerService;
import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import SpringProjects.HRMS.entities.concretes.JobSeekerLanguage;
import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import SpringProjects.HRMS.entities.concretes.JobSeekerSocialMediaAccount;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerExperienceDto;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerLanguageDto;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerSocialMediaAccountDto;
import SpringProjects.HRMS.entities.dtos.JobSeekerRegisterDto;
import SpringProjects.HRMS.entities.dtos.JobSeekerSchoolAddDto;
import SpringProjects.HRMS.entities.mappers.JobSeekerExperienceMapper;
import SpringProjects.HRMS.entities.mappers.JobSeekerLanguageMapper;
import SpringProjects.HRMS.entities.mappers.JobSeekerRegisterMapper;
import SpringProjects.HRMS.entities.mappers.JobSeekerSchoolMapper;
import SpringProjects.HRMS.entities.mappers.JobSeekerSocialMediaAccountMapper;
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
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/jobseeker")
public class JobSeekersController {
    private JobSeekerService jobSeekerService;
    private JobSeekerRegisterMapper jobSeekerRegisterMapper = Mappers.getMapper(JobSeekerRegisterMapper.class);
    private JobSeekerSchoolMapper jobSeekerSchoolMapper = Mappers.getMapper(JobSeekerSchoolMapper.class);
    private JobSeekerExperienceMapper jobSeekerExperienceMapper = Mappers.getMapper(JobSeekerExperienceMapper.class);
    private JobSeekerLanguageMapper jobSeekerLanguageMapper = Mappers.getMapper(JobSeekerLanguageMapper.class);
    private JobSeekerSocialMediaAccountMapper jobSeekerSocialMediaAccountMapper = Mappers.getMapper(JobSeekerSocialMediaAccountMapper.class);
    
    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> addJobSeeker(@RequestBody @Valid JobSeekerRegisterDto dto) {
        JobSeeker jobSeeker = jobSeekerRegisterMapper.convertToEntity(dto);
        
        Result result = jobSeekerService.addJobSeeker(jobSeeker);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobSeeker>>> getAll() {
        return ResponseEntity.ok(jobSeekerService.getAll());
    }
    
    @GetMapping("/getAllExperiencesByJobSeekerId")
    public ResponseEntity<DataResult<List<JobSeekerExperience>>> getAllExperiencesByJobSeekerId(@RequestParam Long jobSeekerId) {
        return ResponseEntity.ok(jobSeekerService.getAllExperiencesByJobSeekerId(jobSeekerId));
    }
    
    @PostMapping("/addSchool")
    public ResponseEntity<?> addSchool(@RequestBody @Valid JobSeekerSchoolAddDto dto) {
        JobSeekerSchool jobSeekerSchool = jobSeekerSchoolMapper.toEntity(dto);
        
        Result result = this.jobSeekerService.addSchool(jobSeekerSchool);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PostMapping("/addSchools")
    public ResponseEntity<?> addSchools(@RequestBody List<@Valid JobSeekerSchoolAddDto> dtos) {
        List<JobSeekerSchool> jobSeekerSchools = this.jobSeekerSchoolMapper.toEntity(dtos);
        
        Result result = this.jobSeekerService.addSchools(jobSeekerSchools);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
  
    @GetMapping("/getSchoolHistory")
    public ResponseEntity<DataResult<List<JobSeekerSchool>>> getSchoolHistory(@RequestParam long jobSeekerId) {
        return ResponseEntity.ok(this.jobSeekerService.getSchoolHistory(jobSeekerId));
    }
    
    @GetMapping("/getOrderedSchoolHistory") 
    public ResponseEntity<DataResult<List<JobSeekerSchool>>> getOrderedSchoolHistory(@RequestParam long jobSeekerId) {
        return ResponseEntity.ok(this.jobSeekerService.getOrderedSchoolHistory(jobSeekerId));
    }
    
    @PostMapping("/addExperience")
    public ResponseEntity<?> addExperience(@RequestBody List<@Valid AddJobSeekerExperienceDto> dto) {
        List<JobSeekerExperience> jobSeekerExperience = this.jobSeekerExperienceMapper.toEntity(dto);
        
        Result result = this.jobSeekerService.addExperience(jobSeekerExperience);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("/getByJobSeekerIdOrderByStartDateDesc")
    public ResponseEntity<DataResult<List<JobSeekerExperience>>> getByJobSeeker_IdOrderByStartDateDesc(@RequestParam long jobSeekerId) {
        return ResponseEntity.ok(this.jobSeekerService.getByJobSeeker_IdOrderByStartDateDesc(jobSeekerId));
    }
    
    @PostMapping("/addJobSeekerLanguage")
    public ResponseEntity<?> addJobSeekerLanguage(@RequestBody @Valid AddJobSeekerLanguageDto dto) {
        JobSeekerLanguage jobSeekerLanguage = this.jobSeekerLanguageMapper.toEntity(dto);
        
        Result result = this.jobSeekerService.addJobSeekerLanguage(jobSeekerLanguage);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/getJobSeekerLanguagesByJobSeekerId")
    public ResponseEntity<DataResult<List<JobSeekerLanguage>>> getJobSeekerLanguagesByJobSeekerId(@RequestParam long jobSeekerId) {
        return ResponseEntity.ok(this.jobSeekerService.getJobSeekerLanguagesByJobSeekerId(jobSeekerId));
    }
    
    @PostMapping("/addSocialMediaAccount")
    public ResponseEntity<?> addSocialMediaAccount(@RequestBody @Valid AddJobSeekerSocialMediaAccountDto dto) {
        JobSeekerSocialMediaAccount entity = this.jobSeekerSocialMediaAccountMapper.toEntity(dto);
        
        Result result = this.jobSeekerService.addSocialMediaAccount(entity);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("/getAllSocialMediaAccounts")
    public ResponseEntity<DataResult<List<JobSeekerSocialMediaAccount>>> getAllSocialMediaAccounts(@RequestParam long jobSeekerId) {
        return ResponseEntity.ok(this.jobSeekerService.getAllSocialMediaAccounts(jobSeekerId));
    }
}
