package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.store.StoreManagerDto;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface StoreManagerMapper {
    StoreManagerMapper INSTANCE = Mappers.getMapper(StoreManagerMapper.class);
    Store storeManagerDtoToStore(StoreManagerDto storeManagerDto);

    StoreManagerDto storeToStoreManagerDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store updateStoreFromStoreManagerDto(StoreManagerDto storeManagerDto, @MappingTarget Store store);

}
