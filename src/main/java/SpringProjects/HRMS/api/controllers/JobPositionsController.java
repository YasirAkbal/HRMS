/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.JobPositionService;
import SpringProjects.HRMS.entities.concretes.JobPosition;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/jobpositions")
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }
    
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobPosition>>> getAll() {
        return ResponseEntity.ok(this.jobPositionService.getAll());
    }
    
    @GetMapping("/findbyid")
    public ResponseEntity<DataResult<JobPosition>> getById(long id) {
        return ResponseEntity.ok(this.jobPositionService.findById(id));
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addJobPosition(@RequestBody @Valid JobPosition jobPosition) {
        Result result = this.jobPositionService.addJobPosition(jobPosition);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
