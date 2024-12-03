package daoImpl;

import dao.DepartmentDao;
import dao.GenericDao;
import database.Database;
import database.GenerateId;
import models.Department;
import models.Hospital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao, GenericDao<Department> {


    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        try {
            for (Hospital hospital : Database.hospitals) {
                if (hospital.getId().equals(id)) {
                    return hospital.getDepartments();
                }
            }
            throw new RuntimeException("Hospital by this ID not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }


    @Override
    public Department findDepartmentByName(String name) {
        try {
            for (Department department : Database.departments) {
                if (department.getDepartmentName().equalsIgnoreCase(name)) {
                    return department;
                }
            }
            throw new RuntimeException("Department by this name not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



        @Override
        public String add(Long hospitalId, Department department) {
            try {
                for (Hospital hospital : Database.hospitals) {
                    if (hospital.getId().equals(hospitalId)) {
                        hospital.getDepartments().add(department);
                        Database.departments.add(department);
                        return "Department added successfully to hospital with ID: " + hospitalId;
                    }
                }
                throw new RuntimeException("Hospital by this ID not found!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            return "Failed to add department.";
        }


    @Override
    public void removeById(Long id) {
        try {
            for (Department department : Database.departments) {
                if (department.getId().equals(id)) {
                    Database.departments.remove(department);
                    for (Hospital hospital : Database.hospitals) {
                        hospital.getDepartments().remove(department);
                    }
                    System.out.println("Department removed successfully.");
                    return;
                }
            }
            throw new RuntimeException("Department by this ID not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String updateById(Long id, Department updatedDepartment) {
        try {
            for (Department department : Database.departments) {
                if (department.getId().equals(id)) {
                    department.setDepartmentName(updatedDepartment.getDepartmentName());
                    return "Department updated successfully.";
                }
            }
            throw new RuntimeException("Department by this ID not found!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Failed to update department.";
    }


}










