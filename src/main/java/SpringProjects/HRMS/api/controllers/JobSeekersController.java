/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.JobSeekerService;
import SpringProjects.HRMS.entities.concretes.JobSeeker;
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
@RequestMapping("api/jobseeker")
public class JobSeekersController {
    JobSeekerService jobSeekerService;
    
    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }
    
    @PostMapping("/add")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerService.addJobSeeker(jobSeeker);
    }
    
    @GetMapping("/getall")
    public DataResult getAll() {
        return jobSeekerService.getAll();
    }
}
