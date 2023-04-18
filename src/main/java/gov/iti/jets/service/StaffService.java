package gov.iti.jets.service;

import gov.iti.jets.persistence.dao.*;
import gov.iti.jets.persistence.dao.interfaces.EntityManagerOperations;
import gov.iti.jets.persistence.dto.staff.ShowStaffDto;
import gov.iti.jets.persistence.dto.staff.StaffListDto;
import gov.iti.jets.persistence.dto.staff.StaffPaymentDto;
import gov.iti.jets.persistence.dto.staff.StaffRentalCustomerDto;
import gov.iti.jets.persistence.entity.*;
import gov.iti.jets.presentation.models.InsertStaffDto;
import gov.iti.jets.presentation.models.Page;
import gov.iti.jets.service.util.exceptions.validationException;
import gov.iti.jets.service.util.mapper.InsertStaffMapper;
import gov.iti.jets.service.util.mapper.StaffMapper;
import gov.iti.jets.service.util.mapper.StaffPaymentMapper;
import gov.iti.jets.service.util.mapper.StaffRentalMapper;
import jakarta.persistence.EntityManager;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class StaffService {
    EntityManagerLoaner entityManagerLoaner=new EntityManagerLoaner();
    private final EntityManagerOperations entityManagerOperations;
    public StaffService(){
        entityManagerOperations = new EntityManagerOperationsProxy();
    }
    public ShowStaffDto getStaffById( Integer staffId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();;
        Optional<Staff> staff = Optional.ofNullable(entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Staff.class), staffId, "find"));
        if (staff.isPresent()&&staff.get().getActive()){
            ShowStaffDto showStaffDto = StaffMapper.INSTANCE.staffToShowStaffDto(staff.get());
            entityManager.flush();
            entityManagerOperations.closeEntityManager();
            return  showStaffDto;
        }
        else {

            throw new validationException("this staff Id is wrong or no longer work with us.");
        }
    }
    public Boolean softDelete(Integer staffId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Staff staff = entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Staff.class), staffId, "find");
        if(staff.getActive()){
        staff.setActive(false);
        Staff result =entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Staff.class), staff, "update");
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return  true;}else {
            throw new validationException("this staff member no longer work with us already");
        }

    }
    public Set<StaffPaymentDto> getStaffPaymentsCreate(Integer staffId) throws validationException {
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Staff staff = entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Staff.class), staffId, "find");
        if(!staff.getActive()){
            throw new validationException("this staff member doesn't work with us any more");
        }else{
            Set<Payment> payments =staff.getPayments();
            Set < StaffPaymentDto> staffPaymentDtos =new HashSet<>();
            payments.forEach(payment -> {
                staffPaymentDtos.add(StaffPaymentMapper.INSTANCE.paymentToStaffPaymentDto(payment));
            });
            entityManager.flush();
            entityManagerOperations.closeEntityManager();
            return staffPaymentDtos;
        }
    }
    public Set<StaffRentalCustomerDto> getStaffMemberRentalsAndCustomers(Integer staffId) throws validationException{
        EntityManager entityManager = entityManagerOperations.getEntityManager();
        Staff staff = entityManagerLoaner.executeCRUD(entityManager, new TransactionImpl<>(Staff.class), staffId, "find");
        if(!staff.getActive()){
            throw new validationException("this staff member doesn't work with us any more");
        }
        Set < StaffRentalCustomerDto> rentalCustomerDtos =new HashSet<>();
        if(!staff.getActive()){
            throw new validationException("this staff member doesn't work with us any more");
        }else {
            Set<Rental> rentals = staff.getRentals();

            rentals.forEach(rental -> {
                rentalCustomerDtos.add(StaffRentalMapper.ONSTANCE.rentalToStaffRentalCustomerDto(rental));
            });
        }
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
            return  rentalCustomerDtos;
    }
    public List<StaffListDto> getStaffList(Page page) throws validationException {
        EntityManager entityManager= entityManagerOperations.getEntityManager();
        StaffImpl staff = new StaffImpl();
        List<StaffListDto> staffListDtos = staff.getStaffList(entityManager,page);
        entityManager.flush();
        entityManagerOperations.closeEntityManager();
        return staffListDtos;

    }
    public boolean insertStaffMember(InsertStaffDto insertStaffDto) throws NoSuchAlgorithmException, validationException {
        EntityManager entityManager= entityManagerOperations.getEntityManager();
        Staff staff = InsertStaffMapper.INSTANCE.insertStaffDtoToStaff(insertStaffDto);
        staff.setActive(true);
        staff.setLastUpdate(new Date());
        String staffPassword =staff.getPassword();
        staff.setPassword(PasswordHandler.hashPassword(staffPassword));
        StaffImpl staffImpl=new StaffImpl();
        StoreService storeService =new StoreService();
        staff.getAddress().setLastUpdate(new Date());

        Store store = null;
        try {
            store = storeService.getStoreById(entityManager,insertStaffDto.getStoreId());
        } catch (validationException e) {
            throw new validationException("this store id is wrong ");
        }
        staff.setStore(store);

        CityImpl cityImpl =new CityImpl();

        Optional<City>  city = null;
        try {
            city = cityImpl.getCityByName(entityManager,insertStaffDto.getAddress().getCity());
            if(city.isPresent()){
                staff.getAddress().setCity(city.get());
            }
        } catch (validationException e) {
            staff.getAddress().getCity().setLastUpdate(new Date());
        }

        CountryImpl countryImpl =new CountryImpl();
        Optional<Country>  country = null;
        try {
            country = countryImpl.getCountryByName(entityManager,insertStaffDto.getAddress().getCountry());
            if(country.isPresent())
                staff.getAddress().getCity().setCountry(country.get());
        } catch (validationException e) {
            staff.getAddress().getCity().getCountry().setLastUpdate(new Date());
        }
        System.out.println("staffAddress ->"+staff.getAddress());
        Staff newStaff =staffImpl.InsertStaff(entityManager,staff);

        entityManager.flush();
        entityManagerOperations.closeEntityManager();

        return true;
    }

}

