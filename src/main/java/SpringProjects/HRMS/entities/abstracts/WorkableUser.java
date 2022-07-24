/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.abstracts;

import SpringProjects.HRMS.core.entities.abstracts.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author yasir
 */
@Data
@Entity
@Table(name="workable_users")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public abstract class WorkableUser extends User {
    @Column(name="name")
    @NotNull 
    @NotBlank
    private String name;
    
    @Column(name="surname")
    @NotNull 
    @NotBlank
    private String surname;
    
    @Column(name="tckn")
    @NotNull 
    @NotBlank
    private String tckn;
    
    @Column(name="birth_date")
    @NotNull 
    private Date birthDate;
}
