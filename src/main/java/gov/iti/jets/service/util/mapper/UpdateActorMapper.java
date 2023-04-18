package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.presentation.models.UpdateActorDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateActorMapper {
    UpdateActorMapper INSTANCE = Mappers.getMapper(UpdateActorMapper.class);

    Actor updateActorDtoToActor(UpdateActorDto updateActorDto);

    UpdateActorDto actorToUpdateActorDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor updateActorFromUpdateActorDto(UpdateActorDto updateActorDto, @MappingTarget Actor actor);
}
