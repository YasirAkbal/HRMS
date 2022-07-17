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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Table(name="cities")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    
    @Column(name="name")
    private String name;
    
    @OneToMany(mappedBy="school")
    private List<JobSeekerSchool> jobSeekerSchoolHistory;
    
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
}
