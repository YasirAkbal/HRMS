/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.JobAdvertisement;
import SpringProjects.HRMS.entities.dtos.JobAdvertisementCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(uses = {EmployerMapper.class, CityMapper.class, JobPositionMapper.class})
public interface JobAdvertisementMapper {
    JobAdvertisementMapper INSTANCE = Mappers.getMapper(JobAdvertisementMapper.class);
    
    @Mapping(target="employer", source="dto.employerId")
    @Mapping(target="city", source="dto.cityId")
    @Mapping(target="position", source="dto.positionId")
    JobAdvertisement convertToEntity(JobAdvertisementCreateDto dto);
}
