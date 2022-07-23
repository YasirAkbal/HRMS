/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {
    public List<JobSeekerExperience> getByJobSeeker_IdOrderByStartDateDesc(long jobSeekerId);
    public List<JobSeekerExperience> getByCompany_Id(long companyId);
    public List<JobSeekerExperience> getByJobPosition_Id(long jobPositionId);
}
