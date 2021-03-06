/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.dataAccess.abstracts;

import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yasir
 */
public interface JobSeekerSchoolDao extends JpaRepository<JobSeekerSchool, Integer> {
    public List<JobSeekerSchool> getByJobSeeker_Id(long jobSeekerId);
    public List<JobSeekerSchool> getBySchool_Id(long schoolId);
    public List<JobSeekerSchool> getBySchoolDepartment_Id(long schoolDepartmentId);
}
