/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeekerSocialMediaAccount;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerSocialMediaAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(uses = {JobSeekerMapper.class, SocialMediaMapper.class})
public interface JobSeekerSocialMediaAccountMapper {
    JobSeekerSocialMediaAccountMapper INSTANCE = Mappers.getMapper(JobSeekerSocialMediaAccountMapper.class);
    
    @Mapping(source = "dto.jobSeekerId", target = "jobSeeker")
    @Mapping(source = "dto.socialMediaId", target = "socialMedia")
    public JobSeekerSocialMediaAccount toEntity(AddJobSeekerSocialMediaAccountDto dto);
}
