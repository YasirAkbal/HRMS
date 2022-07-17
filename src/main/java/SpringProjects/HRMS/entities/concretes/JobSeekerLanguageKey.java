/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobSeekerLanguageKey implements Serializable {
    @Column(name="job_seeker_id")
    private long jobSeekerId;
    
    @Column(name="language_id")
    private int languageId;
}
