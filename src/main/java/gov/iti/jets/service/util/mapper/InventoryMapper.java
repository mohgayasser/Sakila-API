package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.ActorDto;
import gov.iti.jets.persistence.dto.inventory.FilmDto;
import gov.iti.jets.persistence.dto.inventory.InventoryDto;
import gov.iti.jets.persistence.dto.StoreDto;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.persistence.entity.Store;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    Inventory inventoryDtoToInventory(InventoryDto inventoryDto);

    InventoryDto inventoryToInventoryDto(Inventory inventory);


    Actor actorDtoToActor(ActorDto actorDto);

    ActorDto actorToActorDto(Actor actor);


    Store storeDtoToStore(StoreDto storeDto);

    StoreDto storeToStoreDto(Store store);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film filmDtoToFilm(FilmDto filmDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmDto filmToFilmDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film updateFilmFromFilmDto(FilmDto filmDto, @MappingTarget Film film);
}
