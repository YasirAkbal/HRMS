/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.api.controllers;

import SpringProjects.HRMS.business.abstracts.LanguageService;
import SpringProjects.HRMS.entities.concretes.Language;
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
@RequestMapping("api/languages/")
public class LanguagesController {
    
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid Language language) {
        Result result = this.languageService.add(language);
        
        if(!result.isSuccess())
            return ResponseEntity.badRequest().body(result);
        
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("getAll")
    public ResponseEntity<DataResult<List<Language>>> getAll() {
        return ResponseEntity.ok(this.languageService.getAll());
    }
    
}
