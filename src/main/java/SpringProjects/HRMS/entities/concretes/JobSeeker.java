/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.WorkableUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@EqualsAndHashCode(callSuper =false)
@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="workable_user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolHistory","experiences"})
public class JobSeeker extends WorkableUser {
    @Column(name="mernis_confirmed")
    private boolean isMernisConfirmed;
        
    @Column(name="pretext")
    private String pretext;
    
    @ManyToMany
    @JoinTable(
      name = "job_seekers_technologies", 
      joinColumns = @JoinColumn(name = "job_seeker_id"), 
      inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private List<Technology> technologies;
    
    @ManyToMany
    @JoinTable(
      name = "job_seekers_positions", 
      joinColumns = @JoinColumn(name = "jobseeker_id"), 
      inverseJoinColumns = @JoinColumn(name = "position_id"))
    private List<JobPosition> positions;
    
    @OneToMany(mappedBy="jobSeeker")
    private List<JobSeekerSchool> schoolHistory;
    
    @OneToMany(mappedBy = "jobSeeker")
    List<JobSeekerLanguage> languages;
    
    @OneToMany(mappedBy = "jobSeeker")
    List<JobSeekerExperience> experiences;
}
