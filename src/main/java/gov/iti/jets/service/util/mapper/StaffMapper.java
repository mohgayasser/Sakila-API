package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.dto.staff.ShowStaffDto;
import gov.iti.jets.persistence.entity.Staff;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    Staff showStaffDtoToStaff(ShowStaffDto showStaffDto);

    ShowStaffDto staffToShowStaffDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff updateStaffFromShowStaffDto(ShowStaffDto showStaffDto, @MappingTarget Staff staff);
}
