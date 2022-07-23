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
    public Result addJobSeeker(@RequestBody JobSeekerRegisterDto dto) {
        JobSeeker jobSeeker = jobSeekerRegisterMapper.convertToEntity(dto);
        return jobSeekerService.addJobSeeker(jobSeeker);
    }
    
    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return jobSeekerService.getAll();
    }
    
    @GetMapping("/getAllExperiencesByJobSeekerId")
    public DataResult<List<JobSeekerExperience>> getAllExperiencesByJobSeekerId(@RequestParam Long jobSeekerId) {
        return jobSeekerService.getAllExperiencesByJobSeekerId(jobSeekerId);
    }
    
    @PostMapping("/addSchool")
    public Result addSchool(@RequestBody JobSeekerSchoolAddDto dto) {
        JobSeekerSchool jobSeekerSchool = jobSeekerSchoolMapper.toEntity(dto);
        return this.jobSeekerService.addSchool(jobSeekerSchool);
    }

    @PostMapping("/addSchools")
    public Result addSchools(@RequestBody List<JobSeekerSchoolAddDto> dtos) {
        List<JobSeekerSchool> jobSeekerSchools = this.jobSeekerSchoolMapper.toEntity(dtos);
        return this.jobSeekerService.addSchools(jobSeekerSchools);
    } 
  
    @GetMapping("/getSchoolHistory")
    public DataResult<List<JobSeekerSchool>> getSchoolHistory(@RequestParam long jobSeekerId) {
        return this.jobSeekerService.getSchoolHistory(jobSeekerId);
    }
    
    @GetMapping("/getOrderedSchoolHistory") 
    public DataResult<List<JobSeekerSchool>> getOrderedSchoolHistory(@RequestParam long jobSeekerId) {
        return this.jobSeekerService.getOrderedSchoolHistory(jobSeekerId);
    }
    
    @PostMapping("/addExperience")
    public Result addExperience(@RequestBody List<AddJobSeekerExperienceDto> dto) {
        List<JobSeekerExperience> jobSeekerExperience = this.jobSeekerExperienceMapper.toEntity(dto);
        return this.jobSeekerService.addExperience(jobSeekerExperience);
    }
    
    @GetMapping("/getByJobSeekerIdOrderByStartDateDesc")
    public DataResult<List<JobSeekerExperience>> getByJobSeeker_IdOrderByStartDateDesc(long jobSeekerId) {
        return this.jobSeekerService.getByJobSeeker_IdOrderByStartDateDesc(jobSeekerId);
    }
    
    @PostMapping("/addJobSeekerLanguage")
    public Result addJobSeekerLanguage(AddJobSeekerLanguageDto dto) {
        JobSeekerLanguage jobSeekerLanguage = this.jobSeekerLanguageMapper.toEntity(dto);
        System.out.println("debug pointttttttt");
        System.out.println(jobSeekerLanguage.getJobSeeker().getId());
    System.out.println(jobSeekerLanguage.getJobSeeker().getEmail());
        return this.jobSeekerService.addJobSeekerLanguage(jobSeekerLanguage);
    }
    
    @GetMapping("/getJobSeekerLanguagesByJobSeekerId")
    public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguagesByJobSeekerId(long jobSeekerId) {
        return this.jobSeekerService.getJobSeekerLanguagesByJobSeekerId(jobSeekerId);
    }
    
    @PostMapping("/addSocialMediaAccount")
    public Result addSocialMediaAccount(@RequestBody AddJobSeekerSocialMediaAccountDto dto) {
        JobSeekerSocialMediaAccount entity = this.jobSeekerSocialMediaAccountMapper.toEntity(dto);
        return this.jobSeekerService.addSocialMediaAccount(entity);
    }
    
    @GetMapping("/getAllSocialMediaAccounts")
    public DataResult<List<JobSeekerSocialMediaAccount>> getAllSocialMediaAccounts(@RequestParam long jobSeekerId) {
        return this.jobSeekerService.getAllSocialMediaAccounts(jobSeekerId);
    }
}
