/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeeker;
import SpringProjects.HRMS.entities.concretes.JobSeekerSchool;
import SpringProjects.HRMS.entities.concretes.School;
import SpringProjects.HRMS.entities.dtos.JobSeekerSchoolAddDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(componentModel = "default",uses = {SchoolMapper.class, SchoolDepartmentMapper.class, JobSeekerMapper.class})
public interface JobSeekerSchoolMapper {
    JobSeekerSchoolMapper INSTANCE = Mappers.getMapper(JobSeekerSchoolMapper.class);

    @Mapping(target="school", source="dto.schoolId")
    @Mapping(target="schoolDepartment", source="dto.schoolDepartmentId")
    @Mapping(target="jobSeeker", source="dto.jobSeekerId")
    public JobSeekerSchool toEntity(JobSeekerSchoolAddDto dto);
    
    public List<JobSeekerSchool> toEntity(List<JobSeekerSchoolAddDto> dtos);
}
