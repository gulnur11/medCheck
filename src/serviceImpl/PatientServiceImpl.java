package serviceImpl;

import dao.GenericDao;
import dao.PatientDao;
import daoImpl.PatientDaoImpl;
import models.Patient;
import service.GenericService;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService, GenericService<Patient> {

    GenericDao<Patient> genericDao = new PatientDaoImpl();
    PatientDao patientDao = new PatientDaoImpl();



    @Override
    public String add(Long hospitalId, Patient patient) {
        return genericDao.add(hospitalId, patient);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return genericDao.updateById(id, patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
