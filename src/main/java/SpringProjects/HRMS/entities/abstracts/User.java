/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.abstracts;

import SpringProjects.HRMS.entities.concretes.Permission;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author yasir
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public abstract class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //burada bug var, düzelteceğim
    @Id
    @Column(name="id")
    private Long id;
    
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
    
}
