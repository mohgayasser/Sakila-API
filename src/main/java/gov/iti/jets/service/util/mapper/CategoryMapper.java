package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.categories.getCategoryDto;
import gov.iti.jets.persistence.dto.categories.getFilmCategoryDto;
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
    Category categoryDtoToCategory(getCategoryDto getCategoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    getCategoryDto categoryToCategoryDto(Category category);


    @AfterMapping
    default void linkFilmCategories(@MappingTarget Category category) {
        category.getFilmCategories().forEach(filmCategory -> filmCategory.setCategory(category));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory filmCategoryDtoToFilmCategory(getFilmCategoryDto getFilmCategoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    getFilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory updateFilmCategoryFromFilmCategoryDto(getFilmCategoryDto getFilmCategoryDto, @MappingTarget FilmCategory filmCategory);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    Film filmDtoToFilm(FilmDto filmDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

    FilmDto filmToFilmDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film updateFilmFromFilmDto(FilmDto filmDto, @MappingTarget Film film);
}
