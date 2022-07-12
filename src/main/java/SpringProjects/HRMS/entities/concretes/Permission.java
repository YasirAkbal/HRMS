/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.concretes;

import SpringProjects.HRMS.entities.abstracts.User;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author yasir
 */
@Data
@Entity
@Table(name="permissions")
public class Permission {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private long id;
    
    @Column(name="name")
    private String name;
    
    /*@ManyToMany(mappedBy = "permissions")
    private Set<User> users = new HashSet<>();*/
    
    public Permission() {}

    public Permission(long id, String name) {
        this.id = id;
        this.name = name;
    }
}