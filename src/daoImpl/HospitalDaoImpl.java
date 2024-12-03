package daoImpl;

import dao.GenericDao;
import dao.HospitalDao;
import database.Database;
import models.Hospital;
import models.Patient;

import java.util.*;
import java.util.stream.Collectors;

public class HospitalDaoImpl implements  HospitalDao  {


    @Override
    public String addHospital(Hospital hospital) {
        Database.hospitals.add(hospital);
        return "Added new hospital successfully ! ";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        try {
            for (Hospital hospital : Database.hospitals){
                if (hospital.getId().equals(id)){
                    return hospital;
                }
            }throw new RuntimeException("Not found hospital by this Id!");

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public List<Hospital> getAllHospital() {
        return new ArrayList<>(Database.hospitals);
    }



    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    return hospital.getPatients();
                }
            }throw new RuntimeException("Hospital by this id not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




    @Override
    public String deleteHospitalById(Long id) {
        try {
            for (Hospital hospital: Database.hospitals){
                if (hospital.getId().equals(id)){
                    Database.hospitals.remove(hospital);
                    return "Deleted successfully";
                }
            }throw new RuntimeException("Hospital by this id not found ");

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        return null;
    }




    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> result = new HashMap<>();
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getAddress().equalsIgnoreCase(address)) {
                    result.put(hospital.getHospitalName(), hospital);
                }
            }

            if (result.isEmpty()) {
                throw new RuntimeException("No hospitals found at the given address: " + address);
            }
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return result;

    }
}

