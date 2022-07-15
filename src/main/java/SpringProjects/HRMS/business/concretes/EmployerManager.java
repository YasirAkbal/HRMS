/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.EmployerService;
import SpringProjects.HRMS.dataAccess.abstracts.EmployerDao;
import SpringProjects.HRMS.entities.concretes.Employer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.ErrorResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    
    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public Result addEmployer(Employer employer) {
        if(employerDao.existsEmployersByEmail(employer.getEmail()))
            return new ErrorResult("Aynı Email ile birden fazla hesap açamazsınız.");
        
        employerDao.save(employer);
        return new SuccessResult("İşlem başarılı.");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll());
    }
}
