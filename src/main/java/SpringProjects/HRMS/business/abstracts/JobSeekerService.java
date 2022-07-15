/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import java.util.List;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;

/**
 *
 * @author yasir
 */
public interface JobSeekerService {
    public Result addJobSeeker(JobSeeker jobSeeker);
    public DataResult<List<JobSeeker>> getAll();
}
