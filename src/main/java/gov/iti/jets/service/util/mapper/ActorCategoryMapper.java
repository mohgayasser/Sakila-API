package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface ActorCategoryMapper {
    ActorCategoryMapper INSTANCE = Mappers.getMapper(ActorCategoryMapper.class);
    Category actorCategoryDtoToCategory(ActorCategoryDto actorCategoryDto);

    ActorCategoryDto categoryToActorCategoryDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromActorCategoryDto(ActorCategoryDto actorCategoryDto, @MappingTarget Category category);
}
