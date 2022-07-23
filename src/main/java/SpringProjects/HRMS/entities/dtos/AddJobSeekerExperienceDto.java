/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddJobSeekerExperienceDto {
    
    private long jobSeekerId;
    
    private int companyId;
    
    private int jobPositionId;
    
    private Date startDate;
    
    private Date endDate;
    
    private boolean isStillWorking;
    
    private String explanation;
    
}
