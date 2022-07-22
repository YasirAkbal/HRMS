/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.dtos;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementCreateDto {
    
    private int cityId;
    
    private long employerId;
    
    private long positionId;
    
    private boolean isActive;
    
    private Date createDate;
    
    private String definition;

    private Date lastAppDate;
    
    private BigDecimal minSalary;
    
    private BigDecimal maxSalary;
    
    private int numOfOpenPositions;
    
    private String title;
    
}
