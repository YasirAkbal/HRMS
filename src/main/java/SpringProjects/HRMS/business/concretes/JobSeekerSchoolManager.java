/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobSeekerSchoolService;
import SpringProjects.HRMS.dataAccess.abstracts.JobSeekerSchoolDao;
import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.SuccessDataResult;

/**
 *
 * @author yasir
 */
@Service
public class JobSeekerSchoolManager implements JobSeekerSchoolService {
    
    private JobSeekerSchoolDao jobSeekerSchoolDao;

    @Autowired
    public JobSeekerSchoolManager(JobSeekerSchoolDao jobSeekerSchoolDao) {
        this.jobSeekerSchoolDao = jobSeekerSchoolDao;
    }
    
    @Override
    public DataResult<List<JobSeekerSchool>> getByJobSeeker_Id(long jobSeekerId) {
        return new SuccessDataResult<>(this.jobSeekerSchoolDao.getByJobSeeker_Id(jobSeekerId));
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getBySchool_Id(int schoolId) {
        return new SuccessDataResult<>(this.jobSeekerSchoolDao.getBySchool_Id(schoolId));
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getBySchoolDepartment_Id(int schoolDepartmentId) {
        return new SuccessDataResult<>(this.jobSeekerSchoolDao.getBySchoolDepartment_Id(schoolDepartmentId));
    }
    
}
