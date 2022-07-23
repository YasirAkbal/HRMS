/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.SchoolService;
import SpringProjects.HRMS.dataAccess.abstracts.SchoolDao;
import SpringProjects.HRMS.entities.concretes.School;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }
    
    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Okul eklendi.");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(this.schoolDao.findAll());
    }
 
}
