/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import SpringProjects.HRMS.entities.concretes.JobSeekerLanguage;
import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import SpringProjects.HRMS.entities.concretes.JobSeekerSocialMediaAccount;
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
    public Result addSchool(JobSeekerSchool jobSeekerSchool);
    public Result addSchools(List<JobSeekerSchool> jobSeekerSchools);
    public DataResult<List<JobSeekerSchool>> getSchoolHistory(long jobSeekerId);
    public DataResult<List<JobSeekerSchool>> getOrderedSchoolHistory(long jobSeekerId);
    public Result addExperience(List<JobSeekerExperience> jobSeekerExperience);
    public DataResult<List<JobSeekerExperience>> getAllExperiencesByJobSeekerId(Long id);
    public DataResult<List<JobSeekerExperience>> getByJobSeeker_IdOrderByStartDateDesc(long jobSeekerId);
    public Result addJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage);
    public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguagesByJobSeekerId(long jobSeekerId);
    public Result addSocialMediaAccount(JobSeekerSocialMediaAccount account);
    public DataResult<List<JobSeekerSocialMediaAccount>> getAllSocialMediaAccounts(long jobSeekerId);
    public Result addPretext(String pretext);
}
