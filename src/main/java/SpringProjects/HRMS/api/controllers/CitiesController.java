/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.CityService;
import SpringProjects.HRMS.entities.concretes.City;
import java.util.List;
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

/**
 *
 * @author yasir
 */
@RestController
@RequestMapping("api/cities/")
public class CitiesController {
    private CityService cityService;
    
    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }
    
    @PostMapping("add")
    public ResponseEntity<?> addCity(@Valid @RequestBody City city) {
        Result result = this.cityService.addCity(city);
        
        if(!result.isSuccess()) 
            return ResponseEntity.badRequest().body(result);
    
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        DataResult<List<City>> result = this.cityService.getAll();
        
        if(!result.isSuccess()) 
            return ResponseEntity.badRequest().body(result.getMessage());
        
        return ResponseEntity.ok(result);
    }
}
