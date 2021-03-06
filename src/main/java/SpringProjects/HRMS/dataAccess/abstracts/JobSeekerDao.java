/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    public boolean existsJobSeekersByTckn(String tckn);
    public boolean existsJobSeekersByEmail(String email);
    public boolean existsById(Long id);
    public Optional<JobSeeker> getById(Long id);

}
