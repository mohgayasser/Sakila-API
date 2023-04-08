package gov.iti.jets.util.mapper.categories;

import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );
    Category categoryDtoToCategory(CategoryDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);

}
