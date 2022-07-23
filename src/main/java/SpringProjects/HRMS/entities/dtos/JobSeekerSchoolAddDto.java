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
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSchoolAddDto {
    
    private long jobSeekerId;
    
    private int schoolId;
    
    private int schoolDepartmentId;
    
    private Date startDate;
    
    private Date graduateDate;
    
    private boolean isGraduated;
    
    private float grade;
    
}
