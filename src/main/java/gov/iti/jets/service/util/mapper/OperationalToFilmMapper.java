package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.films.OperationalFilmDto;
import gov.iti.jets.persistence.entity.Film;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper
public interface OperationalToFilmMapper {
    OperationalToFilmMapper INSTANCE = Mappers.getMapper(OperationalToFilmMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({@Mapping(source = "specialFeatures", target = "specialFeatures", qualifiedByName = "StringConverter")
    })
    Film OperationalToFilm(OperationalFilmDto operationalFilmDto);
    @Named("StringConverter")
    default  Set<String> stringToSet(String value) {


        Set<String> set
                = Stream.of(value.trim().split("\\s*,\\s*"))
                .collect(Collectors.toSet());
        return set;
    }


}
