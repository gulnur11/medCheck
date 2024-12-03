package database;

public class GenerateId {

    public static Long departmentId = 0L;

    public static Long hospitalId = 0L;

    public static Long doctorId = 0L;

    public static Long patientId = 0L;


    public static Long getDepartmentId(){
        return ++departmentId;
    }

    public static Long getHospitalId(){

        return ++hospitalId;
    }

    public static Long getDoctorId(){

        return ++doctorId;
    }

    public static Long getPatientId(){

        return ++patientId;
    }

}
