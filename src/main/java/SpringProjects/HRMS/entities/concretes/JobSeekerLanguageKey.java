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
    
    @Override
    public int hashCode() {
        return (int)(jobSeekerId + 2*languageId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JobSeekerLanguageKey other = (JobSeekerLanguageKey) obj;
        if (this.jobSeekerId != other.jobSeekerId) {
            return false;
        }
        return this.languageId == other.languageId;
    } 
}
