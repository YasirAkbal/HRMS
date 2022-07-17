/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.dtos.EmployerWithCompanyIdNotCompany;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author yasir
 */
public interface EmployerDao extends JpaRepository<Employer, Integer> {
    public boolean existsEmployersByEmail(String email);
    
    
    /*@Query("Select new springlearning.northwinddemo.entities.dtos.Employer() From Category c Inner Join c.products p")
    Employer saveEmployerWithCompanyId(EmployerWithCompanyIdNotCompany employerDto);*/
}
