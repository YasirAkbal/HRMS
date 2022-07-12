/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.abstracts;

import SpringProjects.HRMS.entities.concretes.Permission;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author yasir
 */
@Data
@Entity
@Table(name="user")
public abstract class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "UserPermission", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "permission_id") }
    )
    private Set<Permission> permissions = new HashSet<>();*/
    
    public User() {}

    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
