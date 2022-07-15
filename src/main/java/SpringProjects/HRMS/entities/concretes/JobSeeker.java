/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.WorkableUser;
import javax.persistence.Entity;
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
@PrimaryKeyJoinColumn(name="workable_user_id")
public class JobSeeker extends WorkableUser {

    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "JobSeekerPosition", 
        joinColumns = { @JoinColumn(name = "jobseeker_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "position_id") }
    )
    private Set<JobPosition> jobPositions = new HashSet<>();*/     
}
