/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.dtos;

import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotNull 
    @NotBlank
    @Size(min=11,max=11)
    private String tckn;
    
    @NotNull 
    @NotBlank
    private String name;
    
    @NotNull 
    @NotBlank
    private String surname;
    
    @Column(name="email")
    @Email
    @NotNull 
    @NotBlank
    private String email;
    
    @NotNull 
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$") //min 8, en az 1 büyük, 1 küçük, 1 sayı
    private String password;
    
    @NotNull 
    private Date birthDate;
    
}
