/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringProjects.HRMS.entities.mappers;

import SpringProjects.HRMS.entities.concretes.Employer;
import SpringProjects.HRMS.entities.dtos.EmployerCreateWithExistingCompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author yasir
 */
@Mapper(componentModel = "default",uses = {RegisteredCompanyMapper.class})
public interface EmployerCreateWithExistingCompanyMapper {
    EmployerCreateWithExistingCompanyMapper INSTANCE = Mappers.getMapper(EmployerCreateWithExistingCompanyMapper.class);
    
    @Mappings({
      @Mapping(target="registeredCompany", source="employerDto.companyId")
    })
    Employer convertToEntity(EmployerCreateWithExistingCompanyDto employerDto);
}
