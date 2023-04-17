package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.staff.StaffPaymentDto;
import gov.iti.jets.persistence.entity.Payment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffPaymentMapper {
    StaffPaymentMapper INSTANCE = Mappers.getMapper(StaffPaymentMapper.class);

    Payment staffPaymentDtoToPayment(StaffPaymentDto staffPaymentDto);

    StaffPaymentDto paymentToStaffPaymentDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment updatePaymentFromStaffPaymentDto(StaffPaymentDto staffPaymentDto, @MappingTarget Payment payment);
}
