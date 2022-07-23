/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobSeekerLanguage;
import SpringProjects.HRMS.entities.dtos.AddJobSeekerLanguageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(uses = {JobSeekerMapper.class, LanguageMapper.class, LanguageLevelMapper.class})
public interface JobSeekerLanguageMapper {
    JobSeekerLanguageMapper INSTANCE = Mappers.getMapper(JobSeekerLanguageMapper.class);
    
    @Mapping(source = "dto.jobSeekerId", target = "jobSeeker")
    @Mapping(source = "dto.languageId", target = "language")
    @Mapping(source = "dto.languageLevelId", target = "languageLevel")
    public JobSeekerLanguage toEntity(AddJobSeekerLanguageDto dto);
}
