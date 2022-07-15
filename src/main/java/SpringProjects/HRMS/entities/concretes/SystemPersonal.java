/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="system_personals")
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonal extends User {
    @Column(name="start_date_of_work")
    private Date startDateOfWork; 
}
