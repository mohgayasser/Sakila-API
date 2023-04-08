package gov.iti.jets.util.mapper;

import gov.iti.jets.persistence.dto.StoreDto;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StorMapper {

    Store storeDtoToStore(StoreDto storeDto);

    StoreDto storeToStoreDto(Store store);

    StorMapper INSTANCE = Mappers.getMapper(StorMapper.class);


}
