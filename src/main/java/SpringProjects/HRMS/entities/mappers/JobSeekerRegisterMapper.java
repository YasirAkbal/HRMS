/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.dtos.JobSeekerRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper
public interface JobSeekerRegisterMapper {
    JobSeekerRegisterMapper INSTANCE = Mappers.getMapper(JobSeekerRegisterMapper.class);
    
    public JobSeeker convertToEntity(JobSeekerRegisterDto dto);
}
