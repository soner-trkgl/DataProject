package org.cse222;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Hashtable;



/**
 * All needed data are
 * stored here. All objects
 * have a reference to this
 * class.
 */
public class Database {
    /**
     * Doctors stored in database in
     * a ArrayList.
     */
    private Hashtable<Integer,Doctor> doctors;
    
    
    private Hashtable<Integer,Patient> patients;
    
    
    private ArrayList<Consultant> consultants;

    /**
     *     All Users List
     */
    private ArrayList<Person> allUsers;

    /**
     * Needed objects will be added.
     */
    public Database(){
        doctors = new Hashtable<>();
        consultants = new ArrayList<>();
        allUsers = new ArrayList<>();
        patients = new Hashtable<Integer,Patient>();
    }

    /**
     * Adds all user in a one Person List
     */
    public void allUsersP(){
        allUsers.addAll(doctors.values());
        allUsers.addAll(consultants);
        System.out.println(allUsers.get(allUsers.size()-1).getJobType());

    }

    public Hashtable<Integer, Doctor> searchByNameAndSurname(String name, String surname){
        Hashtable<Integer, Doctor> foundDoctors = new Hashtable<>();

        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getName().equals(name)
            && doctors.get(i).getSurName().equals(surname)){
                foundDoctors.put(i,doctors.get(i));
            }
        }

        return foundDoctors;
    }


    public Hashtable<Integer, Doctor> getDoctors() {
        return doctors;
    }

    public Hashtable<Integer,Patient> getPatients(){
    	return patients;
    }
    
    public void setDoctors(Hashtable<Integer, Doctor> doctors) {
        this.doctors = doctors;
    }
    
    public Patient getPatientByName(String name){
        for(Integer d: doctors.keySet())
            for(Patient ret:doctors.get(d).getPatientList())
                if(ret.getName()==name)
                    return ret;
        return null;
    }

    public ArrayList<Consultant> getConsultants() {
        return consultants;
    }

    public void setConsultants(ArrayList<Consultant> consultants) {
        this.consultants = consultants;
    }
    
    public void addPatient(Patient pt) {
    	if( pt != null ) {
    		patients.put(pt.getId() ,pt);
    	}
    		
    }
    
    
    
    public void addConsultants( Consultant cs ) {
    	consultants.add(cs);
    }
    
}
