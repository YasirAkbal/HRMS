/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerLanguage;
import SpringProjects.HRMS.entities.concretes.JobSeekerLanguageKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, JobSeekerLanguageKey> {
    public List<JobSeekerLanguage> getByJobSeeker_Id(long jobSeekerId);
}
