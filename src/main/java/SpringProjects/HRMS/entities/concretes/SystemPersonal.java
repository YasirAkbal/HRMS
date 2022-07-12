/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.WorkableUser;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author yasir
 */
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name="system_personal")
public class SystemPersonal extends WorkableUser {
    private Date startDayOfWork;
    
    public SystemPersonal() {}

    public SystemPersonal(Date startDayOfWork, String name, String surname, String tckn, Date birthDate, long id, String email, String password) {
        super(name, surname, tckn, birthDate, id, email, password);
        this.startDayOfWork = startDayOfWork;
    } 
}
