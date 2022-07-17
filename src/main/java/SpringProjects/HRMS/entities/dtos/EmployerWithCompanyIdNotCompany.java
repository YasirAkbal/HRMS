/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.dtos;

import SpringProjects.HRMS.entities.concretes.Employer;
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
public class EmployerWithCompanyIdNotCompany {
    private int companyId;
    private String email;
    private String password;
}
