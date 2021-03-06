/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="language_levels")
@AllArgsConstructor
@NoArgsConstructor
public class LanguageLevel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private short id;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(mappedBy="languageLevel")
    private List<JobSeekerLanguage> jobSeekerLanguages;
}
