package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.customer.CustomerPaymentDto;
import gov.iti.jets.persistence.entity.Payment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerPaymentMapper {
    CustomerPaymentMapper INSTANCE = Mappers.getMapper(CustomerPaymentMapper.class);

    Payment customerPaymentDtoToPayment(CustomerPaymentDto customerPaymentDto);

    CustomerPaymentDto paymentToCustomerPaymentDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment updatePaymentFromCustomerPaymentDto(CustomerPaymentDto customerPaymentDto, @MappingTarget Payment payment);
}
