package gov.iti.jets.util.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class filmListConverter implements AttributeConverter<List<String>,String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
     return null;
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        List<String> set
                = Stream.of(dbData.trim().split("\\s*,\\s*"))
                .map(n -> n.toLowerCase())
                .sorted(Comparator.comparingInt(String::length))
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.toList());

        return set;
    }
}
