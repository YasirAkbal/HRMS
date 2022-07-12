/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.WorkableUser;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author yasir
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="job_seeker")
public class JobSeeker extends WorkableUser {
    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "JobSeekerPosition", 
        joinColumns = { @JoinColumn(name = "jobseeker_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "position_id") }
    )
    private Set<JobPosition> jobPositions = new HashSet<>();*/

    public JobSeeker() {}

    public JobSeeker(String name, String surname, String tckn, Date birthDate, long id, String email, String password) {
        super(name, surname, tckn, birthDate, id, email, password);
    }
    
}
