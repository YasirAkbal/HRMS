/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobAdvertisementService;
import SpringProjects.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import SpringProjects.HRMS.entities.concretes.JobAdvertisement;
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
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    
    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }
    
    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
        return new SuccessDataResult<>(jobAdvertisementDao.getByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByOrderByCreateDateDesc() {
        return new SuccessDataResult<>(jobAdvertisementDao.getAllByOrderByCreateDateDesc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployer_EmployerId(long employerId) {
        return new SuccessDataResult<>(jobAdvertisementDao.getByEmployer_Id(employerId));
    }

    @Override
    public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }
    
}
