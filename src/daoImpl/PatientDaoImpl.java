package daoImpl;

import dao.GenericDao;
import dao.PatientDao;
import database.Database;
import models.Patient;
import models.Hospital;

import java.util.*;


public class PatientDaoImpl implements PatientDao, GenericDao<Patient> {

    @Override
    public String add(Long hospitalId, Patient patient) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.getPatients().add(patient);
                    Database.patients.add(patient);
                    return "Patient added successfully to hospital!";
                }
            }
            throw new RuntimeException("Hospital with ID " + hospitalId + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to add patient!";
    }


    @Override
    public void removeById(Long id) {
        try {
            for (Patient patient : Database.patients) {
                if (patient.getId().equals(id)) {
                    Database.patients.remove(patient);
                    for (Hospital hospital : Database.hospitals) {
                        hospital.getPatients().remove(patient);
                    }
                    System.out.println("Patient removed successfully!");
                    return;
                }
            }
                throw new RuntimeException("Patient with ID " + id + " not found!");

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    @Override
    public String updateById(Long id, Patient patient) {
        try {
            for (Patient existingPatient : Database.patients) {
                if (existingPatient.getId().equals(id)) {
                    existingPatient.setFirstName(patient.getFirstName());
                    existingPatient.setLastName(patient.getLastName());
                    existingPatient.setAge(patient.getAge());
                    existingPatient.setGender(patient.getGender());
                    return "Patient updated successfully!";
                }
            }
            throw new RuntimeException("Patient with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to update patient!";
    }


    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    hospital.getPatients().addAll(patients);
                    Database.patients.addAll(patients);
                    return "Patients added to hospital successfully!";
                }
            }
            throw new RuntimeException("Hospital with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to add patients to hospital!";
    }


    @Override
    public Patient getPatientById(Long id) {
        try {
            for (Patient patient : Database.patients) {
                if (patient.getId().equals(id)) {
                    return patient;
                }
            }
            throw new RuntimeException("Patient with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


     @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> patientByAge = new HashMap<>();
        try {
            for (Patient patient : Database.patients) {
                patientByAge.put(patient.getAge(), patient);
            }
            if (patientByAge.isEmpty()) {
                throw new RuntimeException("No patients found!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return patientByAge;
    }




     @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> sortedPatients = new ArrayList<>(Database.patients);
        try {
            if (ascOrDesc.equalsIgnoreCase("asc")) {
                sortedPatients.sort(Comparator.comparingInt(Patient::getAge));
            } else if (ascOrDesc.equalsIgnoreCase("desc")) {
                sortedPatients.sort(Comparator.comparingInt(Patient::getAge).reversed());
            } else {
                throw new RuntimeException("Invalid sorting order: " + ascOrDesc);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return sortedPatients;
    }
     

}





 /*

    @Override
    public void removeById(Long id) {
        try {
            Patient patientToRemove = null;
            for (Patient patient : Database.patients) {
                if (patient.getId().equals(id)) {
                    patientToRemove = patient;
                    break;
                }
            }
            if (patientToRemove != null) {
                Database.patients.remove(patientToRemove);
                for (Hospital hospital : Database.hospitals) {
                    hospital.getPatients().remove(patientToRemove);
                }
                System.out.println("Patient removed successfully!");
            } else {
                throw new RuntimeException("Patient with ID " + id + " not found!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
     */
