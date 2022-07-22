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
public class JobSeekerRegisterDto {
    
    private String tckn;
    
    private String name;
    
    private String surname;
    
    private String email;
    
    private String password;
    
    private Date birthDate;
    
}
