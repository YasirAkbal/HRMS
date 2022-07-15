/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobPositionService;
import SpringProjects.HRMS.dataAccess.abstracts.JobPositionDao;
import SpringProjects.HRMS.entities.concretes.JobPosition;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.ErrorDataResult;
import springprojects.HRMS.core.utilities.results.ErrorResult;
import springprojects.HRMS.core.utilities.results.Result;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;
import springprojects.HRMS.core.utilities.results.SuccessResult;

/**
 *
 * @author yasir
 */
@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;
    
    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }
    
    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(this.jobPositionDao.findAll());
    }

    @Override
    public DataResult<JobPosition> findById(long id) {
        Optional<JobPosition> position = this.jobPositionDao.findById(id);
        
        if(position.isEmpty())
            return new ErrorDataResult<>("Belirtilen id'ye ait pozisyon bulunamadı.");
        
        return new SuccessDataResult<>(position.get());
    }

    @Override
    public Result addJobPosition(JobPosition jobPosition) {
        if(jobPositionDao.existsJobPositionByName(jobPosition.getName())) 
            return new ErrorResult("Eklenmek istenilen pozisyon zaten mevcut.");
        
        jobPositionDao.save(jobPosition);
        return new SuccessResult("Pozisyon eklendi");
    }    
}
