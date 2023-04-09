package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.categories.getFilmCategoryIdDto;
import gov.iti.jets.persistence.dto.films.getFilmDto;
import gov.iti.jets.persistence.dto.films.getInventoryDto;
import gov.iti.jets.persistence.dto.StoreDto;
import gov.iti.jets.persistence.dto.films.getFilmCategoryDto;
import gov.iti.jets.persistence.dto.films.getFilmLanguageDto;
import gov.iti.jets.persistence.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = {FilmActorMapper.class,AddressMapper.class})
public interface FilmMapper {
    Film filmDtoToFilm(getFilmDto getFilmDto);

    getFilmDto filmToFilmDto(Film film);

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @AfterMapping
    default void linkInventories(@MappingTarget Film film) {
        film.getInventories().forEach(inventory -> inventory.setFilm(film));
    }

    @AfterMapping
    default void linkFilmActors(@MappingTarget Film film) {
        film.getFilmActors().forEach(filmActor -> filmActor.setFilm(film));
    }

    //map language
    Language filmLanguageDtoToLanguage(getFilmLanguageDto getFilmLanguageDto);

    getFilmLanguageDto languageToFilmLanguageDto(Language language);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Set<Inventory> inventoriesDtoToInventories(Set<getInventoryDto> inventoriesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    getInventoryDto inventoryToInventoryDto(Inventory inventories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Inventory inventoryDtoToInventory(getInventoryDto inventoriesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Set<getInventoryDto> inventoryToInventoryDto(Set<Inventory> inventories);

    ///// Film Category Mapper for Set And One Category
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Set<FilmCategory> filmCategoriesDtoToFilmCategories(Set<getFilmCategoryDto> filmCategoriesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Set<getFilmCategoryDto> filmCategoriesToFilmCategoriesDto(Set<FilmCategory> filmCategories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    FilmCategory filmCategoryDtoToFilmCategory(getFilmCategoryDto getFilmCategoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    getFilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory);

    /////////////////////////////////////////////////////////////////////////////////////
    Store storeDtoToStore(StoreDto storeDto);

    StoreDto storeToStoreDto(Store store);


    FilmCategoryId filmCategoryIdDtoToFilmCategoryId(getFilmCategoryIdDto getFilmCategoryIdDto);

    getFilmCategoryIdDto filmCategoryIdToFilmCategoryIdDto(FilmCategoryId filmCategoryId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryId updateFilmCategoryIdFromFilmCategoryIdDto(getFilmCategoryIdDto getFilmCategoryIdDto, @MappingTarget FilmCategoryId filmCategoryId);
}
