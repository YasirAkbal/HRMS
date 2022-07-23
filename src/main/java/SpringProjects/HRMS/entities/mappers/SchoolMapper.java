/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.School;
import SpringProjects.HRMS.entities.dtos.SchoolRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(uses = {CityMapper.class})
public interface SchoolMapper {
    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);
    
    @Mapping(target="city", source="dto.cityId")
    public School toEntity(SchoolRegisterDto dto);
    
    public School toEntity(Integer id);
}
