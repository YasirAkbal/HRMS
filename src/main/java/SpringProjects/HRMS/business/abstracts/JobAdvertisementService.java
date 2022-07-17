/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.JobAdvertisement;
import java.util.List;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;

/**
 *
 * @author yasir
 */
public interface JobAdvertisementService {
    public Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
    public DataResult<List<JobAdvertisement>> getByIsActiveTrue();
    public DataResult<List<JobAdvertisement>> getAllByOrderByCreateDateDesc();
    public DataResult<List<JobAdvertisement>> getByEmployer_EmployerId(long employerId);
    public Result setActiveStatusFalse(long id);
}
