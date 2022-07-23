/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeekerExperience;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerExperienceDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(uses = {JobSeekerMapper.class, CompanyMapper.class, JobPositionMapper.class})
public interface JobSeekerExperienceMapper {
    JobSeekerExperienceMapper INSTANCE = Mappers.getMapper(JobSeekerExperienceMapper.class);
    
    @Mapping(target="jobSeeker", source="dto.jobSeekerId")
    @Mapping(target="company", source="dto.companyId")
    @Mapping(target="jobPosition", source="dto.jobPositionId")
    public JobSeekerExperience toEntity(AddJobSeekerExperienceDto dto);
    
    public List<JobSeekerExperience> toEntity(List<AddJobSeekerExperienceDto> dto);
}
