package gov.iti.jets.service.util.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class specialFeatureConverter implements AttributeConverter<Set<String>,String> {
    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {
        if (attribute == null) {
            return null;
        }

        return String.join(",", attribute);
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {

        Set<String> set
                = Stream.of(dbData.trim().split("\\s*,\\s*"))
                .collect(Collectors.toSet());
        return set;
    }
}
