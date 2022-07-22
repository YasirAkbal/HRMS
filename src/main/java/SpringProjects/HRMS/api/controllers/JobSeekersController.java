/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.JobSeekerService;
import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import SpringProjects.HRMS.entities.dtos.JobSeekerRegisterDto;
import SpringProjects.HRMS.entities.mappers.JobSeekerRegisterMapper;
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

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/jobseeker")
public class JobSeekersController {
    JobSeekerService jobSeekerService;
    private JobSeekerRegisterMapper jobSeekerRegisterMapper = Mappers.getMapper(JobSeekerRegisterMapper.class);
    
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
}
