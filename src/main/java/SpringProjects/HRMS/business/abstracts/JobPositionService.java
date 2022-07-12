/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.JobPosition;
import java.util.List;

/**
 *
 * @author yasir
 */
public interface JobPositionService {
    public List<JobPosition> getAll();
}
