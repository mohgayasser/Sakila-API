package gov.iti.jets.persistence.dao;

import gov.iti.jets.persistence.dao.interfaces.StaffDao;
import gov.iti.jets.persistence.dto.staff.StaffListDto;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.persistence.views.FilmList;
import gov.iti.jets.persistence.views.StaffList;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.StaffListMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffImpl implements StaffDao {
    EntityManagerLoaner entityManagerLoaner;
    public StaffImpl(){
        entityManagerLoaner = new EntityManagerLoaner();

    }
    @Override
    public List<StaffListDto> getStaffList(EntityManager entityManager, Page page) throws validationException {
        String SQLStr ="From StaffList sl";
        List<StaffList> StaffList = entityManagerLoaner.executeList(entityManager,new TransactionImpl<>(StaffList.class),SQLStr,new HashMap<>(),page);
        List<StaffListDto> staffListDtos =new ArrayList<>();
        StaffList.forEach(staffList -> {
            staffListDtos.add(StaffListMapper.INSTANCE.staffListToStaffListDto(staffList));
        });
        return  staffListDtos;

    }

    @Override
    public Staff InsertStaff(EntityManager entityManager, Staff staff) throws validationException {
        Staff newStaff = entityManagerLoaner.executeCRUD(entityManager,new TransactionImpl<>(Staff.class),staff,"update");
        return newStaff;
    }

}
