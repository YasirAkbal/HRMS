/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobPosition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */

@Mapper
public interface JobPositionMapper {
    JobPositionMapper INSTANCE = Mappers.getMapper(JobPositionMapper.class);
    
    public JobPosition toEntity(Long id);
}
