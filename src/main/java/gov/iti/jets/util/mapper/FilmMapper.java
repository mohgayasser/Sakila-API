package gov.iti.jets.util.mapper;

import gov.iti.jets.persistence.dto.categories.FilmCategoryIdDto;
import gov.iti.jets.persistence.dto.films.InventoryDto;
import gov.iti.jets.persistence.dto.StoreDto;
import gov.iti.jets.persistence.dto.films.FilmCategoryDto;
import gov.iti.jets.persistence.dto.films.FilmDto;
import gov.iti.jets.persistence.dto.films.FilmLanguageDto;
import gov.iti.jets.persistence.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = {FilmActorMapper.class,AddressMapper.class})
public interface FilmMapper {
    Film filmDtoToFilm(FilmDto filmDto);

    FilmDto filmToFilmDto(Film film);

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
    Language filmLanguageDtoToLanguage(FilmLanguageDto filmLanguageDto);

    FilmLanguageDto languageToFilmLanguageDto(Language language);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Set<Inventory> inventoriesDtoToInventories(Set<InventoryDto> inventoriesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    InventoryDto inventoryToInventoryDto(Inventory inventories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Inventory inventoryDtoToInventory(InventoryDto inventoriesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Set<InventoryDto> inventoryToInventoryDto(Set<Inventory> inventories);

    ///// Film Category Mapper for Set And One Category
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Set<FilmCategory> filmCategoriesDtoToFilmCategories(Set<FilmCategoryDto> filmCategoriesDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    Set<FilmCategoryDto> filmCategoriesToFilmCategoriesDto(Set<FilmCategory> filmCategories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    FilmCategory filmCategoryDtoToFilmCategory(FilmCategoryDto filmCategoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    FilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory);

    /////////////////////////////////////////////////////////////////////////////////////
    Store storeDtoToStore(StoreDto storeDto);

    StoreDto storeToStoreDto(Store store);


    FilmCategoryId filmCategoryIdDtoToFilmCategoryId(FilmCategoryIdDto filmCategoryIdDto);

    FilmCategoryIdDto filmCategoryIdToFilmCategoryIdDto(FilmCategoryId filmCategoryId);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryId updateFilmCategoryIdFromFilmCategoryIdDto(FilmCategoryIdDto filmCategoryIdDto, @MappingTarget FilmCategoryId filmCategoryId);
}
