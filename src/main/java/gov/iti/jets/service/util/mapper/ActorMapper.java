package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.actor.ActorDto;
import gov.iti.jets.persistence.entity.Actor;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    Actor actorDtoToActor(ActorDto actorDto);

    ActorDto actorToActorDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor updateActorFromActorDto(ActorDto actorDto, @MappingTarget Actor actor);
}
