/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Table(name="registered_companies")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "company_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
public class RegisteredCompany extends Company {
    
    @JsonIgnore
    @OneToMany(mappedBy = "registeredCompany", fetch = FetchType.LAZY)
    private List<Employer> employers;
    
}
