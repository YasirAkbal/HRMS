/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.LanguageLevel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper
public interface LanguageLevelMapper {
    LanguageLevelMapper INSTANCE = Mappers.getMapper(LanguageLevelMapper.class);
    
    public LanguageLevel toEntity(Integer id);
}
