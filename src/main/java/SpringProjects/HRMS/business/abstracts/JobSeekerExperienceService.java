/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import java.util.List;
import springprojects.HRMS.core.utilities.results.DataResult;

/**
 *
 * @author yasir
 */
public interface JobSeekerExperienceService {
    public DataResult<List<JobSeekerExperience>> getByJobSeekerId(long jobSeekerId);
    public DataResult<List<JobSeekerExperience>> getByCompanyId(int companyId);
    public DataResult<List<JobSeekerExperience>> getByJobPositionId(long jobPositionId);
}
