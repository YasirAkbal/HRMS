/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.dtos;

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
public class AddJobSeekerSocialMediaAccountDto {
    
    private long jobSeekerId;
    
    private short socialMediaId;
    
    private String url;
    
}
