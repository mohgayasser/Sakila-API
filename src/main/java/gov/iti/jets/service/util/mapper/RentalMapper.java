package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.PaymentDto;
import gov.iti.jets.persistence.dto.RentalDto;
import gov.iti.jets.persistence.dto.customer.CustomerRentalDto;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.persistence.entity.Rental;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    Rental rentalDtoToRental(CustomerRentalDto rentalDto);

    CustomerRentalDto rentalToRentalDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental updateRentalFromRentalDto(CustomerRentalDto rentalDto, @MappingTarget Rental rental);

}
