package daoImpl;

import dao.DoctorDao;
import dao.GenericDao;
import database.Database;
import database.GenerateId;
import models.Department;
import models.Doctor;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

import static database.GenerateId.doctorId;

public class DoctorDaoImpl implements DoctorDao, GenericDao<Doctor> {


    @Override
    public Doctor findDoctorById(Long id) {
        try {
            for (Doctor doctor : Database.doctors) {
                if (doctor.getId().equals(id)) {
                    return doctor;
                }
            }
            throw new RuntimeException("Doctor with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        try {
            for (Department department : Database.departments) {
                if (department.getId().equals(departmentId)) {
                    for (Long doctorId : doctorsId) {
                        Doctor doctor = findDoctorById(doctorId);
                        department.getDoctors().add(doctor);
                        return "Doctors assigned to department  successfully!";
                    }
                }
            }
            throw new RuntimeException("Department with ID " + departmentId + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to assign doctors to department.";
    }

    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган
    // Department'ге табылган Doctor'лорду кошуп коюнунуз


    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    return hospital.getDoctors();
                }
            }
            throw new RuntimeException("Hospital with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }


    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            for (Department department : Database.departments) {
                if (department.getId().equals(id)) {
                    return department.getDoctors();
                }
            }
            throw new RuntimeException("Department with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }


    @Override
    public String add(Long hospitalId, Doctor doctor) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(hospitalId)) {
                    hospital.getDoctors().add(doctor);
                    Database.doctors.add(doctor);
                    return "Doctor added successfully to hospital with ID: " + hospitalId;
                }
            }
            throw new RuntimeException("Hospital with ID " + hospitalId + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to add doctor.";
    }


    @Override
    public void removeById(Long id) {
        try {
            for (Doctor doctor : Database.doctors) {
                if (doctor.getId().equals(id)) {
                    Database.doctors.remove(doctor);
                    for (Hospital hospital : Database.hospitals) {
                        hospital.getDoctors().remove(doctor);
                    }
                    for (Department department : Database.departments) {
                        department.getDoctors().remove(doctor);
                    }
                    System.out.println("Doctor removed successfully.");
                } else  {
                    throw new RuntimeException("Doctor with ID " + id + " not found!");
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }




    @Override
    public String updateById(Long id, Doctor updatedDoctor) {
        try {
            for (Doctor doctor : Database.doctors) {
                if (doctor.getId().equals(id)) {
                    doctor.setFirstName(updatedDoctor.getFirstName());
                    doctor.setLastName(updatedDoctor.getLastName());
                    doctor.setGender(updatedDoctor.getGender());
                    doctor.setExperienceYear(updatedDoctor.getExperienceYear());
                    return "Doctor updated successfully.";
                }
            }
            throw new RuntimeException("Doctor with ID " + id + " not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to update doctor.";
    }









}





//
// @Override
//    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
//        try {
//            Department department = null;
//            for (Department dep : Database.departments) {
//                if (dep.getId().equals(departmentId)) {
//                    department = dep;
//                    break;
//                }
//            }if (department == null) {
//                throw new RuntimeException("Department with ID " + departmentId + " not found!");
//            }
//            for (Long doctorId : doctorsId) {
//                Doctor doctor = findDoctorById(doctorId);
//                if (doctor != null) {
//                    department.getDoctors().add(doctor);
//                } else {
//                    System.out.println("Doctor with ID " + doctorId + " not found. Skipping...");
//                }
//            }return "Doctors assigned to department successfully!";
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }return "Failed to assign doctors to department.";
//    }


//
//    @Override
//    public void removeById(Long id) {
//        try {
//            Doctor doctorToRemove = null;
//            for (Doctor doctor : Database.doctors) {
//                if (doctor.getId().equals(id)) {
//                    doctorToRemove = doctor;
//                    break;
//                }
//            }
//            if (doctorToRemove != null) {
//                Database.doctors.remove(doctorToRemove);
//                for (Hospital hospital : Database.hospitals) {
//                    hospital.getDoctors().remove(doctorToRemove);
//                }
//                for (Department department : Database.departments) {
//                    department.getDoctors().remove(doctorToRemove);
//                }
//                System.out.println("Doctor removed successfully.");
//            } else {
//                throw new RuntimeException("Doctor with ID " + id + " not found!");
//            }
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//


