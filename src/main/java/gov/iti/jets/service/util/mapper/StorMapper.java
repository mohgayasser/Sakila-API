package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.StoreDto;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StorMapper {

    Store storeDtoToStore(StoreDto storeDto);

    StoreDto storeToStoreDto(Store store);

    StorMapper INSTANCE = Mappers.getMapper(StorMapper.class);


}
