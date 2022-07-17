/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobAdvertisement;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>  {
    public List<JobAdvertisement> getByIsActiveTrue();
    public List<JobAdvertisement> getAllByOrderByCreateDateDesc();
    public List<JobAdvertisement> getByEmployer_Id(long employerId);
    public Optional<JobAdvertisement> findById(long id);
}
