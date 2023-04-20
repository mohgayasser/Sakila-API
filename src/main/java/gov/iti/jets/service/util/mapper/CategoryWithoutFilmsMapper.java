package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.presentation.models.CategorywithoutFilmsDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface CategoryWithoutFilmsMapper {
    CategoryWithoutFilmsMapper INSTANCE = Mappers.getMapper(CategoryWithoutFilmsMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category categorywithoutFilmsDtoToCategory(CategorywithoutFilmsDto categorywithoutFilmsDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategorywithoutFilmsDto categoryToCategorywithoutFilmsDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromCategorywithoutFilmsDto(CategorywithoutFilmsDto categorywithoutFilmsDto, @MappingTarget Category category);
}
