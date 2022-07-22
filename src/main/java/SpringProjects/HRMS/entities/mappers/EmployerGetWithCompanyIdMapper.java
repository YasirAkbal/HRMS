/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.dtos.EmployerGetWithCompanyIdDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper
public interface EmployerGetWithCompanyIdMapper {
    EmployerGetWithCompanyIdMapper INSTANCE = Mappers.getMapper(EmployerGetWithCompanyIdMapper.class);
    
    
    @Mappings({
      @Mapping(target="companyId", source="employer.registeredCompany.id")
    })
    EmployerGetWithCompanyIdDto convertToDto(Employer employer);
    
    List<EmployerGetWithCompanyIdDto> convertToDto(List<Employer> employers);
}
