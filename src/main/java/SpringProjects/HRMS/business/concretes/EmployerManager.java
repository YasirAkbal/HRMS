/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.EmployerService;
import SpringProjects.HRMS.dataAccess.abstracts.EmployerDao;
import SpringProjects.HRMS.dataAccess.abstracts.RegisteredCompanyDao;
import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.concretes.RegisteredCompany;
import SpringProjects.HRMS.entities.dtos.EmployerCreateWithExistingCompanyDto;
import SpringProjects.HRMS.entities.dtos.EmployerGetWithCompanyIdDto;
import SpringProjects.HRMS.entities.mappers.EmployerCreateWithExistingCompanyMapper;
import SpringProjects.HRMS.entities.mappers.EmployerGetWithCompanyIdMapper;
import java.util.List;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
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
    private RegisteredCompanyDao registeredCompanyDao;
    private EmployerCreateWithExistingCompanyMapper mapper = Mappers.getMapper(EmployerCreateWithExistingCompanyMapper.class);
    
    @Autowired
    public EmployerManager(EmployerDao employerDao, RegisteredCompanyDao registeredCompanyDao) {
        this.employerDao = employerDao;
        this.registeredCompanyDao = registeredCompanyDao;
    }

    @Override
    public Result addEmployerWithNewCompany(Employer employer) {
        if(employerDao.existsEmployersByEmail(employer.getEmail()))
            return new ErrorResult("Aynı Email ile birden fazla hesap açamazsınız.");
        
        RegisteredCompany registeredCompany = registeredCompanyDao.save(employer.getRegisteredCompany());
        employer.setRegisteredCompany(registeredCompany);
        
        employerDao.save(employer);
        return new SuccessResult("İşlem başarılı.");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll());
    }

    @Override
    public Result addEmployerWithExistingCompany(Employer employer) {
        if(employerDao.existsEmployersByEmail(employer.getEmail()))
            return new ErrorResult("Aynı Email ile birden fazla hesap açamazsınız.");
        
        Optional<RegisteredCompany> registeredCompanyOpt = registeredCompanyDao.findById(employer.getRegisteredCompany().getId());
        if(registeredCompanyOpt.isEmpty())
            return new ErrorResult("Geçersiz şirket id'si.");
        
        employerDao.save(employer);
        return new SuccessResult("İşlem başarılı.");
    }
}
