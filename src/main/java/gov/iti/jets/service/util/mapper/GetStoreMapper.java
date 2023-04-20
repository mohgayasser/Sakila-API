package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.films.getStoreDto;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GetStoreMapper {
    GetStoreMapper INSTANCE = Mappers.getMapper(GetStoreMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    Store getStoreDtoToStore(getStoreDto getStoreDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    getStoreDto storeTogetStoreDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store updateStoreFromgetStoreDto(getStoreDto getStoreDto, @MappingTarget Store store);
}
