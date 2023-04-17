package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.PaymentDto;
import gov.iti.jets.persistence.dto.StoreDto;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper {

    Store storeDtoToStore(StoreDto storeDto);

    StoreDto storeToStoreDto(Store store);

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);


    Payment paymentDtoToPayment(PaymentDto paymentDto);

    PaymentDto paymentToPaymentDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment updatePaymentFromPaymentDto(PaymentDto paymentDto, @MappingTarget Payment payment);
}
