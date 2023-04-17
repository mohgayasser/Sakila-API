package gov.iti.jets.persistence.dao.interfaces;

import gov.iti.jets.persistence.dto.staff.StaffListDto;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface StaffDao {
    public List<StaffListDto> getStaffList(EntityManager entityManager,Page page) throws validationException;
    public Staff InsertStaff(EntityManager entityManager, Staff staff)throws validationException;
}
