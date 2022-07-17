/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.Company;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
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
@EqualsAndHashCode(callSuper=false)
@Table(name="unregistered_companies")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "company_id")
public class UnregisteredCompany extends Company {
    
}
