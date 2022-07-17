/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {
    
}
