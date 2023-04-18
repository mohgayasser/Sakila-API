package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.presentation.models.NewActorDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InsertActorMapper {
    InsertActorMapper INSTANCE = Mappers.getMapper(InsertActorMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor newActorDtoToActor(NewActorDto newActorDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NewActorDto actorToNewActorDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor updateActorFromNewActorDto(NewActorDto newActorDto, @MappingTarget Actor actor);
}
