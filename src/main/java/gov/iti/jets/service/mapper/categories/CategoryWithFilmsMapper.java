package gov.iti.jets.service.mapper.categories;


import gov.iti.jets.persistence.dto.categories.CategoryWIthFilmsDto;
import gov.iti.jets.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryWithFilmsMapper {
    CategoryWithFilmsMapper INSTANCE = Mappers.getMapper( CategoryWithFilmsMapper.class );

    CategoryWIthFilmsDto categoryToCategoryDto(Category category);
    
    Category categoryToCategoryDto(CategoryWIthFilmsDto categoryDto);
}
