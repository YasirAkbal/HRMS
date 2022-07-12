/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.User;
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
@Table(name="employer")
public class Employer extends User {
    @Column(name="company_name")
    private String companyName;
    
    @Column(name="website")
    private String webSite;
    
    @Column(name="phone")
    private String phone;

    public Employer() {
    }

    public Employer(String companyName, String webSite, String phone, long id, String email, String password) {
        super(id, email, password);
        this.companyName = companyName;
        this.webSite = webSite;
        this.phone = phone;
    }
}
