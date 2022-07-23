/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import java.util.List;
import springprojects.HRMS.core.utilities.results.DataResult;

/**
 *
 * @author yasir
 */
public interface JobSeekerSchoolService {
    public DataResult<List<JobSeekerSchool>> getByJobSeeker_Id(long jobSeekerId);
    public DataResult<List<JobSeekerSchool>> getBySchool_Id(int schoolId);
    public DataResult<List<JobSeekerSchool>> getBySchoolDepartment_Id(int schoolDepartmentId);
}
