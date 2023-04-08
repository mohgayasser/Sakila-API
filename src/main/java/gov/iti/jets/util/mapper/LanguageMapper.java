package gov.iti.jets.util.mapper;

import gov.iti.jets.persistence.dto.FilmCategoryDto;
import gov.iti.jets.persistence.entity.FilmCategory;
import gov.iti.jets.persistence.entity.Language;
import gov.iti.jets.persistence.entity.LanguageDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FilmMapper.class, FilmActorMapper.class})
public interface LanguageMapper {

    Language languageDtoToLanguage(LanguageDto languageDto);

    LanguageDto languageToLanguageDto(Language language);

    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory filmCategoryDtoToFilmCategory(FilmCategoryDto filmCategoryDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory);

}
