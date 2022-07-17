/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Entity
@Table(name="job_advertisements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="position_id")
    private JobPosition position;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;
    
    @Column(name="title")
    private String title;
    
    @Column(name="definition")
    private String definition;
    
    @Column(name="min_salary")
    private BigDecimal minSalary;
    
    @Column(name="max_salary")
    private BigDecimal maxSalary;
    
    @Column(name="num_of_open_positions")
    private int numOfOpenPositions;
    
    @Column(name="last_app_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAppDate;
    
    @Column(name="create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Column(name="is_active")
    private boolean isActive;
}
