/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Entity
@Table(name="social_media_accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(JobSeekerSocialMediaAccountId.class)
public class JobSeekerSocialMediaAccount {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "job_seeker_id", referencedColumnName = "workable_user_id")
    @JsonIgnore
    private JobSeeker jobSeeker;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "social_media_id", referencedColumnName = "id")
    private SocialMedia socialMedia;
    
    @Column(name="url")
    private String url;
    
}
