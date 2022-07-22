/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.business.abstracts;

import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.dtos.EmployerCreateWithExistingCompanyDto;
import java.util.List;
import springprojects.HRMS.core.utilities.results.DataResult;
import springprojects.HRMS.core.utilities.results.Result;

/**
 *
 * @author yasir
 */
public interface EmployerService {
    public Result addEmployerWithNewCompany(Employer employer);
    public Result addEmployerWithExistingCompany(Employer employer);
    public DataResult<List<Employer>> getAll();
}
