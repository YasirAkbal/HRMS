/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers_languages")
public class JobSeekerLanguage {
    @EmbeddedId
    private JobSeekerLanguageKey id;
    
    @ManyToOne
    @MapsId("jobSeekerId")
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;
    
    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name="language_id")
    private Language language;
    
    @ManyToOne
    @JoinColumn(name="language_level_id")
    private LanguageLevel languageLevel;
}
