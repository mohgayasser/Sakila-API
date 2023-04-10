package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
import gov.iti.jets.persistence.dto.RentalDto;
import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.entity.Rental;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDtoToCustomer(CustomerDto customerDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerDto customerToCustomerDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromCustomerDto(CustomerDto customerDto, @MappingTarget Customer customer);

    default Set<Integer> inventoriesToInventoryIds(Set<Inventory> inventories) {
        return inventories.stream().map(Inventory::getId).collect(Collectors.toSet());
    }


    Rental rentalDtoToRental(RentalDto rentalDto);

    RentalDto rentalToRentalDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental updateRentalFromRentalDto(RentalDto rentalDto, @MappingTarget Rental rental);


}
