/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.CityService;
import SpringProjects.HRMS.entities.concretes.City;
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
@RequestMapping("api/cities/")
public class CitiesController {
    private CityService cityService;
    
    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }
    
    @PostMapping("add")
    public Result addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }
    
    @GetMapping("getAll")
    public DataResult<List<City>> getAll() {
        return cityService.getAll();
    }
}
