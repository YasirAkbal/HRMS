/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.PermissionService;
import SpringProjects.HRMS.dataAccess.abstracts.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yasir
 */
@Service
public class PermissionManager implements PermissionService {
    private PermissionDao permissionDao;

    @Autowired
    public PermissionManager(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    } 
}
