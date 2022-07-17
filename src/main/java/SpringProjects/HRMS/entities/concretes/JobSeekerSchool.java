/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Data
@Entity
@Table(name="job_seekers_school_histories")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSchool {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    
    @ManyToOne
    @JoinColumn(name="school_id")
    private School school;
    
    @ManyToOne
    @JoinColumn(name="department_id")
    private SchoolDepartment schoolDepartment;
    
    @ManyToOne
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;
    
    @JoinColumn(name="start_date")
    private Date startDate;
    
    @JoinColumn(name="graduate_date")
    private Date graduateDate;
    
    @JoinColumn(name="is_graduated")
    private boolean isGraduated;
    
    @JoinColumn(name="grade")
    private float grade;
}
