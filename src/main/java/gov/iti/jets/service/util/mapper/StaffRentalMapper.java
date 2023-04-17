package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.staff.StaffRentalCustomerDto;
import gov.iti.jets.persistence.entity.Rental;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffRentalMapper {
    StaffRentalMapper ONSTANCE = Mappers.getMapper(StaffRentalMapper.class);


    Rental staffRentalCustomerDtoToRental(StaffRentalCustomerDto staffRentalCustomerDto);

    StaffRentalCustomerDto rentalToStaffRentalCustomerDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental updateRentalFromStaffRentalCustomerDto(StaffRentalCustomerDto staffRentalCustomerDto, @MappingTarget Rental rental);
}
