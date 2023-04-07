package gov.iti.jets.service.util;

import gov.iti.jets.persistence.entity.enums.FilmRating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.naming.directory.Attributes;
import java.util.stream.Stream;

@Converter
public class filmRatingConverter implements AttributeConverter<FilmRating,String> {
    @Override
    public String convertToDatabaseColumn(FilmRating attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.pg;
    }

    @Override
    public FilmRating convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(FilmRating.values())
                .filter(c -> c.pg.equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
