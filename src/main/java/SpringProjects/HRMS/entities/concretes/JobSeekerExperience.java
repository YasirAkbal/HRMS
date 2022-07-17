/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.Company;
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
@Table(name="job_seeker_experiences")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerExperience {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;
    
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name="job_position_id")
    private JobPosition jobPosition;
    
    @Column(name="start_date")
    private Date startDate;
    
    @Column(name="end_date")
    private Date endDate;
    
    @Column(name="is_still_working")
    private boolean isStillWorking;
    
    @Column(name="explanation")
    private String explanation;
}
