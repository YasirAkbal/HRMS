/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author yasir
 */
public class JobSeekerSocialMediaAccountId implements Serializable {
    
    private long jobSeeker;
    private short socialMedia;
    
    
    @Override
    public int hashCode() {
        return Objects.hash(jobSeeker,socialMedia);
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
        final JobSeekerSocialMediaAccountId other = (JobSeekerSocialMediaAccountId) obj;
        if (this.jobSeeker != other.jobSeeker) {
            return false;
        }
        return this.socialMedia == other.socialMedia;
    }
}
