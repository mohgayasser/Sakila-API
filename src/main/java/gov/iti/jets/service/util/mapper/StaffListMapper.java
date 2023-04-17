package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.views.StaffList;
import gov.iti.jets.persistence.dto.staff.StaffListDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "cdi")
public interface StaffListMapper {
    StaffListMapper INSTANCE = Mappers.getMapper(StaffListMapper.class);
    StaffList staffListDtoToStaffList(StaffListDto staffListDto);

    StaffListDto staffListToStaffListDto(StaffList staffList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    StaffList updateStaffListFromStaffListDto(StaffListDto staffListDto, @MappingTarget StaffList staffList);
}
