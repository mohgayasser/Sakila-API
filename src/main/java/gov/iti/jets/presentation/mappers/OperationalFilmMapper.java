package gov.iti.jets.presentation.mappers;

import gov.iti.jets.presentation.models.OperationalFilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OperationalFilmMapper {
    OperationalFilmMapper INSTANCE = Mappers.getMapper(OperationalFilmMapper.class);
    gov.iti.jets.persistence.dto.films.OperationalFilmDto presentationToService(OperationalFilmDto operationalFilmDto);

    OperationalFilmDto  serviceToPresentation(gov.iti.jets.persistence.dto.films.OperationalFilmDto filmDto);
}
