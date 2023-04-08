package gov.iti.jets.util.mapper;

import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.dto.categories.FilmCategoryDto;
import gov.iti.jets.persistence.dto.inventory.FilmDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.FilmCategory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = FilmMapper.class)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CategoryDto categoryToCategoryDto(Category category);


    @AfterMapping
    default void linkFilmCategories(@MappingTarget Category category) {
        category.getFilmCategories().forEach(filmCategory -> filmCategory.setCategory(category));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory filmCategoryDtoToFilmCategory(FilmCategoryDto filmCategoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory updateFilmCategoryFromFilmCategoryDto(FilmCategoryDto filmCategoryDto, @MappingTarget FilmCategory filmCategory);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    Film filmDtoToFilm(FilmDto filmDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    FilmDto filmToFilmDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film updateFilmFromFilmDto(FilmDto filmDto, @MappingTarget Film film);
}
