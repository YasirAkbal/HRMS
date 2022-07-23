/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerPretextDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(uses = {JobSeekerMapper.class})
public interface JobSeekerPretextMapper {
    JobSeekerPretextMapper INSTANCE = Mappers.getMapper(JobSeekerPretextMapper.class);
    
    //@Mapping(source = "dto.jobSeekerId", target = "id")
    @Mapping(source = "dto.pretext", target = "pretext")
    public JobSeeker toJobSeekerEntity(AddJobSeekerPretextDto dto);
}
