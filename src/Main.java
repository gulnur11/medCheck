
import database.GenerateId;
import enums.Gender;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;
import service.HospitalService;
import serviceImpl.DepartmentServiceImpl;
import serviceImpl.DoctorServiceImpl;
import serviceImpl.HospitalServiceImpl;
import serviceImpl.PatientServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        HospitalService hospitalService = new HospitalServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();



        Scanner scanner = new Scanner(System.in);

         try {
             while (true) {
                 System.out.println("1.Add hospital: ");
                 System.out.println("2.Find Hospital By Id: ");
                 System.out.println("3. Get all hospital: ");
                 System.out.println("4.Get all patient from Hospital: ");
                 System.out.println("5.Delete hospital by Id: ");
                 System.out.println("6.Get all hospital by address: ");

                 System.out.println("7.Add department to hospital:");
                 System.out.println("8.Remove department by ID:");
                 System.out.println("9.Update department by ID:");
                 System.out.println("10.Get All Department by Hospital ID:");
                 System.out.println("11.Find Department by name:");

                 System.out.println("12.Add doctors to hospital:");
                 System.out.println("13.Remove doctor by ID:");
                 System.out.println("14.Update doctor by ID:");
                 System.out.println("15.Find Doctor By Id: ");
                 System.out.println("16.Assign Doctor to Department:");
                 System.out.println("17.Get doctor by hospital ID: ");
                 System.out.println("18.Get doctor by department ID: ");

                 System.out.println("19.Add patient:");
                 System.out.println("20.Remove By Id:");
                 System.out.println("21.Update By Id:");
                 System.out.println("22.Add Patients To Hospital: ");
                 System.out.println("23.Get Patient By Id:");
                 System.out.println("24.Get Patient By Age: ");
                 System.out.println("25.Sort Patients By Age: ");


                 System.out.println("SELECT THE METHOD: ");

                 int choice = scanner.nextInt();

                 if (choice == 26) {
                     System.out.println("EXIT ! ");
                     break;
                 }

                 switch (choice) {
                     case 1 -> {
                         System.out.println("Write hospital name");
                         scanner.nextLine();
                         String name = scanner.nextLine();
                         System.out.println("Write hospital address ");
                         String address = scanner.nextLine();
                         Hospital hospital = new Hospital(GenerateId.getHospitalId(), name, address);
                         System.out.println(hospital);
                         System.out.println(hospitalService.addHospital(hospital));
                     }
                     case 2 -> {
                         System.out.println("Write ID ");
                         Long hospitalID = scanner.nextLong();
                         System.out.println(hospitalService.findHospitalById(hospitalID));
                     }
                     case 3 -> {
                         System.out.println(hospitalService.getAllHospital());
                     }
                     case 4 -> {
                         System.out.println("Write ID ");
                         Long hospitalID = scanner.nextLong();
                         System.out.println(hospitalService.getAllPatientFromHospital(hospitalID));
                     }
                     case 5 -> {
                         System.out.println("Write ID ");
                         Long hospitalID = scanner.nextLong();
                         System.out.println(hospitalService.deleteHospitalById(hospitalID));
                     }
                     case 6 -> {
                         System.out.println("Write your address:");
                         scanner.nextLine();
                         String address = scanner.nextLine();
                         System.out.println(hospitalService.getAllHospitalByAddress(address));
                     }
                     case 7 -> {
                         System.out.println("Write hospital ID:");
                         Long id = scanner.nextLong();
                         scanner.nextLine();
                         System.out.println("Write department name: ");
                         String name = scanner.nextLine();
                         Department department = new Department(GenerateId.getDepartmentId(), name);
                         System.out.println(department);
                         System.out.println(departmentService.add(id, department));
                     }
                     case 8 -> {
                         System.out.println("Write department ID:");
                         scanner.nextLong();
                         Long ID = scanner.nextLong();
                         departmentService.removeById(ID);
                     }
                     case 9 -> {
                         System.out.println("Write department ID:");
                         scanner.nextLong();
                         Long id = scanner.nextLong();
                         System.out.println("Write new department name: ");
                         scanner.nextLine();
                         String newName = scanner.nextLine();
                         Department newDepartment = new Department(GenerateId.getDepartmentId(), newName);
                         System.out.println(newDepartment);
                         System.out.println(departmentService.updateById(id, newDepartment));
                     }
                     case 10 -> {
                         System.out.println("Write hospital ID:");
                         scanner.nextLong();
                         Long id = scanner.nextLong();
                         System.out.println(departmentService.getAllDepartmentByHospital(id));
                     }
                     case 11 -> {
                         scanner.nextLine();
                         System.out.println("Write department name: ");
                         String name = scanner.nextLine();
                         System.out.println(departmentService.findDepartmentByName(name));
                     }
                     case 12 -> {
                         System.out.println("Write hospital ID:");
                         Long id = scanner.nextLong();
                         scanner.nextLine();
                         System.out.println("Write doctor's name: ");
                         String name = scanner.nextLine();
                         System.out.println("Write doctor's lastname: ");
                         String lastName = scanner.nextLine();
                         System.out.println("Write (MALE/FEMALE):");
                         String genderInput = scanner.nextLine();
                         Gender gender = Gender.valueOf(genderInput.toUpperCase());
                         System.out.println("Write experience year: ");
                         int experienceYear = scanner.nextInt();
                         Doctor doctor = new Doctor(GenerateId.getDoctorId(), name, lastName, gender, experienceYear);
                         System.out.println(doctor);
                         System.out.println(doctorService.add(id, doctor));
                     }
                     case 13 -> {
                         System.out.println("Write ID to remove:");
                         Long id = scanner.nextLong();
                         doctorService.removeById(id);
                     }
                     case 14 -> {
                         System.out.println("Write hospital ID:");
                         Long id = scanner.nextLong();
                         scanner.nextLine();
                         System.out.println("Write  doctor's new name: ");
                         String newName = scanner.nextLine();
                         System.out.println("Write doctor's new lastname: ");
                         String newLastName = scanner.nextLine();
                         scanner.nextInt();
                         System.out.println("Write new experience year: ");
                         int newExperienceYear = scanner.nextInt();
                         Doctor newDoctor = new Doctor(GenerateId.getDoctorId(), newName, newLastName, Gender.MALE, newExperienceYear);
                         System.out.println(newDoctor);
                         System.out.println(doctorService.updateById(id, newDoctor));
                     }
                     case 15 -> {
                         System.out.println("Write doctor's ID:");
                         Long id = scanner.nextLong();
                         System.out.println(doctorService.findDoctorById(id));
                     }
                     case 16 -> {
                         System.out.println("Write department's ID:");
                         Long id = scanner.nextLong();
                         System.out.println("Write doctor's ID:");
                         Long id1 = scanner.nextLong();
                         List<Long> doctorIds = List.of(id1);
                         System.out.println(doctorService.assignDoctorToDepartment(id, doctorIds));
                     }
                     case 17 -> {
                         System.out.println("Write hospital ID:");
                         Long id = scanner.nextLong();
                         System.out.println(doctorService.getAllDoctorsByHospitalId(id));
                     }
                     case 18 -> {
                         System.out.println("Write department's ID:");
                         Long id = scanner.nextLong();
                         System.out.println(doctorService.getAllDoctorsByDepartmentId(id));
                     }
                     case 19 -> {
                         System.out.println("Write hospital ID:");
                         Long id = scanner.nextLong();
                         scanner.nextLine();
                         System.out.println("Write first name");
                         String name = scanner.nextLine();
                         System.out.println("Write last name");
                         String lastName = scanner.nextLine();
                         System.out.println("Write age ");
                         int age = scanner.nextInt();
                         System.out.println("Write (MALE/FEMALE):");
                         scanner.nextLine();
                         String genderInput = scanner.nextLine();
                         Gender gender = Gender.valueOf(genderInput.toUpperCase());
                         Patient patient = new Patient(GenerateId.getPatientId(), name, lastName, age, gender);
                         System.out.println(patient);
                         System.out.println(patientService.add(id, patient));
                     }
                     case 20 -> {
                         System.out.println("Write ID to remove:");
                         Long id = scanner.nextLong();
                         patientService.removeById(id);
                     }
                     case 21 -> {
                         System.out.println("Write hospital ID:");
                         Long id = scanner.nextLong();
                         scanner.nextLine();
                         System.out.println("Write patient's new name: ");
                         String newName = scanner.nextLine();
                         System.out.println("Write patient's new lastname: ");
                         String newLastName = scanner.nextLine();
                         scanner.nextInt();
                         System.out.println("Write new age: ");
                         int newAge = scanner.nextInt();
                         System.out.println("Write (MALE/FEMALE):");
                         scanner.nextLine();
                         String genderInput = scanner.nextLine();
                         Gender gender = Gender.valueOf(genderInput.toUpperCase());
                         Patient newPatient = new Patient(GenerateId.getPatientId(), newName, newLastName, newAge, gender);
                         System.out.println(newPatient);
                         System.out.println(patientService.updateById(id, newPatient));
                     }
                     case 22 -> {
                         System.out.println("Write hospital ID:");
                         Long hospitalId = scanner.nextLong();
                         System.out.print("Сколько пациентов вы хотите добавить? ");
                         int count = scanner.nextInt();
                         scanner.nextLine();

                         List<Patient> patients = new ArrayList<>();
                         for (int i = 0; i < count; i++) {
                             System.out.println("Добавление пациента " + (i + 1) + ":");

                             System.out.print("Введите имя пациента: ");
                             String firstName = scanner.nextLine();

                             System.out.print("Введите фамилию пациента: ");
                             String lastName = scanner.nextLine();

                             System.out.print("Введите возраст пациента: ");
                             int age = scanner.nextInt();
                             scanner.nextLine();

                             System.out.print("Введите пол пациента (MALE/FEMALE): ");
                             Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                             Patient patient = new Patient(GenerateId.getPatientId(), firstName, lastName, age, gender);
                             patients.add(patient);
                         }
                         System.out.println(patientService.addPatientsToHospital(hospitalId, patients));
                     }
                     case 23 -> {
                         System.out.println("Write patient's ID:");
                         Long patientId = scanner.nextLong();
                         System.out.println(patientService.getPatientById(patientId));
                     }
                     case 24 -> {
                         System.out.println(patientService.getPatientByAge());
                     }
                     case 25 -> {
                         System.out.print("Введите порядок сортировки (asc/desc): ");
                         String sortOrder = scanner.next();
                         System.out.println(patientService.sortPatientsByAge(sortOrder));
                     }
                     default -> System.out.println("Invalid operation. Try again.");
                 }
             }
         }catch (InputMismatchException e){
             System.out.println("Error: Write only Numerals!");
         }finally {
                 System.out.println("Operation is over!");
         }



    }
}