/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobSeekerExperienceService;
import SpringProjects.HRMS.dataAccess.abstracts.CompanyDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobPositionDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerDao;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerExperienceDao;
import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.ErrorDataResult;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;

/**
 *
 * @author yasir
 */
@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {
    
    private JobSeekerExperienceDao jobSeekerExperienceDao;
    private JobSeekerDao jobSeekerDao;
    private CompanyDao companyDao;
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobSeekerExperienceManager(JobSeekerExperienceDao jobSeekerExperienceDao, JobSeekerDao jobSeekerDao, CompanyDao companyDao, JobPositionDao jobPositionDao) {
        this.jobSeekerExperienceDao = jobSeekerExperienceDao;
        this.jobSeekerDao = jobSeekerDao;
        this.companyDao = companyDao;
        this.jobPositionDao = jobPositionDao;
    }
    
    @Override
    public DataResult<List<JobSeekerExperience>> getByJobSeekerId(long jobSeekerId) {
        if(!jobSeekerDao.existsById(jobSeekerId))
            return new ErrorDataResult<>("Geçersiz job seeker id'si.");
        
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.getByJobSeeker_IdOrderByStartDateDesc(jobSeekerId));
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getByCompanyId(int companyId) {
        if(!companyDao.existsById(companyId))
            return new ErrorDataResult<>("Geçersiz company id'si.");
        
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.getByCompany_Id(companyId));
    }

    @Override
    public DataResult<List<JobSeekerExperience>> getByJobPositionId(long jobPositionId) {
        if(!jobPositionDao.existsById(jobPositionId))
            return new ErrorDataResult<>("Geçersiz job position id'si.");
        
        return new SuccessDataResult<>(this.jobSeekerExperienceDao.getByJobPosition_Id(jobPositionId));
    }
    
}
