package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.customer.CustomerListDto;
import gov.iti.jets.persistence.views.CustomerList;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerListMapper {
    CustomerListMapper INSTANCE = Mappers.getMapper(CustomerListMapper.class);
    CustomerList customerListDtoToCustomerList(CustomerListDto customerListDto);

    CustomerListDto customerListToCustomerListDto(CustomerList customerList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerList updateCustomerListFromCustomerListDto(CustomerListDto customerListDto, @MappingTarget CustomerList customerList);
}
