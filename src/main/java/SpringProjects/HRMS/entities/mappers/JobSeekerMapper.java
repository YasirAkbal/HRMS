/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper
public interface JobSeekerMapper {
    JobSeekerMapper INSTANCE = Mappers.getMapper(JobSeekerMapper.class);
    
    public JobSeeker toEntity(Long id);
}
