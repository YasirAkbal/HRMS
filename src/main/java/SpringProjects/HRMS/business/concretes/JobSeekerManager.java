/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobSeekerService;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerDao;
import SpringProjects.HRMS.entities.concretes.JobSeeker;
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
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    
    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        if(jobSeekerDao.existsJobPositionsByTckn(jobSeeker.getTckn()))
            return new ErrorResult("Aynı TCKN ile birden fazla hesap açamazsınız.");
        else if(jobSeekerDao.existsJobPositionsByEmail(jobSeeker.getEmail()))
            return new ErrorResult("Aynı Email ile birden fazla hesap açamazsınız.");
        
        jobSeekerDao.save(jobSeeker);
        return new SuccessResult("İşlem başarılı.");
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(jobSeekerDao.findAll());
    }
}
