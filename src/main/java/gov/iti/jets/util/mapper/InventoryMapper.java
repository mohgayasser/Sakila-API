package gov.iti.jets.util.mapper;

import gov.iti.jets.persistence.dto.InventoryDto;
import gov.iti.jets.persistence.dto.categories.CategoryDto;
import gov.iti.jets.persistence.dto.films.FilmDto;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Inventory;
import gov.iti.jets.util.mapper.categories.CategoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper( InventoryMapper.class );
    Inventory inventoryDtoToInventory(InventoryDto inventoryDto);
    InventoryDto inventoryToInventoryDto(Inventory inventory);
    Set<Inventory> inventoryDtoToInventory(Set<InventoryDto> inventoriesDto);
    Set<InventoryDto> inventoryToInventoryDto(Set<Inventory> inventories);


}
