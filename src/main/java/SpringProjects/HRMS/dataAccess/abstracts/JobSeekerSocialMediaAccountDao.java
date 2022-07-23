/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerSocialMediaAccount;
import SpringProjects.HRMS.entities.concretes.JobSeekerSocialMediaAccountId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobSeekerSocialMediaAccountDao extends JpaRepository<JobSeekerSocialMediaAccount, JobSeekerSocialMediaAccountId> {
    public List<JobSeekerSocialMediaAccount> getByJobSeeker_Id(long jobSeekerId);
}
