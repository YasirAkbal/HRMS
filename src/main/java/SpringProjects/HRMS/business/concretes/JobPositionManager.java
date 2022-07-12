/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.concretes;

import SpringProjects.HRMS.business.abstracts.JobPositionService;
import SpringProjects.HRMS.dataAccess.abstracts.JobPositionDao;
import SpringProjects.HRMS.entities.concretes.JobPosition;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yasir
 */
@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;
    
    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }
    
    @Override
    public List<JobPosition> getAll() {
        return this.jobPositionDao.findAll();
    }
    
}
