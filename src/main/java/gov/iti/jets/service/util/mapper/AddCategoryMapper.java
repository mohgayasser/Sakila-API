package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.presentation.models.AddCategoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface AddCategoryMapper {
    AddCategoryMapper INSTANCRE = Mappers.getMapper(AddCategoryMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category addCategoryDtoToCategory(AddCategoryDto addCategoryDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AddCategoryDto categoryToAddCategoryDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromAddCategoryDto(AddCategoryDto addCategoryDto, @MappingTarget Category category);
}
