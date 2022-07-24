/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.SchoolService;
import SpringProjects.HRMS.entities.concretes.School;
import SpringProjects.HRMS.entities.dtos.SchoolRegisterDto;
import SpringProjects.HRMS.entities.mappers.SchoolMapper;
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
import org.springframework.web.bind.annotation.RestController;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/schools/")
public class SchoolsController {
    private SchoolService schoolService;
    private SchoolMapper schoolMapper = Mappers.getMapper(SchoolMapper.class);

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    
    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid SchoolRegisterDto dto) {
        School school = schoolMapper.toEntity(dto);
        
        Result result = this.schoolService.add(school);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("getAll")
    public ResponseEntity<DataResult<List<School>>> getAll() {
        return ResponseEntity.ok(this.schoolService.getAll());
    }
}
