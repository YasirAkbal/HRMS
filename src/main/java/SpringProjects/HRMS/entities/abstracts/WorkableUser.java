/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.abstracts;

import java.util.Date;
import javax.persistence.Column;
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
@Table(name="workable")
public abstract class WorkableUser extends User {
    @Column(name="name")
    private String name;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="tckn")
    private String tckn;
    
    @Column(name="birth_date")
    private Date birthDate;
    
    public WorkableUser() {
        super();
    }

    public WorkableUser(String name, String surname, String tckn, Date birthDate, long id, String email, String password) {
        super(id, email, password);
        this.name = name;
        this.surname = surname;
        this.tckn = tckn;
        this.birthDate = birthDate;
    }
}
