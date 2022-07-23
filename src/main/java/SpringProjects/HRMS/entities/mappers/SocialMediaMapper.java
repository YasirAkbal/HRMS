/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.SocialMedia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */

@Mapper
public interface SocialMediaMapper {
    SocialMediaMapper INSTANCE = Mappers.getMapper(SocialMediaMapper.class);
    
    public SocialMedia toEntity(Short id);
}
