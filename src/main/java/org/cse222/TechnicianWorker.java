package org.cse222;

import java.util.ArrayList;

public class TechnicianWorker extends Person {

    private Database databaseRef;

    public class Menu{
        private Scanner reader = new Scanner(System.in);
        Menu(){
            String menuOpt;
            System.out.print("Welcome back ");
            char gen = getGender();
            if(gen=='f' || gen=='F') System.out.print("Mrs ");
            else if(gen=='m' || gen=='M') System.out.print("Mr ");
            else System.out.print("Their ");
            System.out.println(getName());
            do{
                System.out.println("Please select a task:(Type \"back\" to return)");
                System.out.println("1)Fill analysis results.");
                menuOpt = reader.nextLine();
                if(menuOpt.equalsIgnoreCase("back")) return;
                else if(menuOpt.equalsIgnoreCase("1")) anRes();
                else System.out.println("Unrecognized option. Try again.");
            }while(true);
        }
        void anRes(){
            String patientn;
            String line;
            Patient mypat;
            do{
                //check patient
                System.out.println("Please enter patient name:");
                patientn = reader.nextLine();
                if(patientn.equalsIgnoreCase("back")) return;
                mypat = databaseRef.getPatientByName(patientn);
                if(mypat!=null) break;
                System.out.println("This patient doesn't exist.");
            }while (true);
            ArrayList<String>anLines = new ArrayList<String>();
            do{
                //check patient
                System.out.println("Fill analysis results below.");
                System.out.println("Type \"save\" to update database.");
                System.out.println("Type \"back\" to return without saving.");
                line = reader.nextLine();
                if(line.equalsIgnoreCase("save")) break;
                if(line.equalsIgnoreCase("back")) return;
                anLines.add(line);
            }while (true);
            fillAnalysisResults(mypat,anLines);
        }
    }
    /*addAnalysisResults parametresi generate edilecek!!!! */
    public void fillAnalysisResults(Patient patient, ArrayList<String> needAnalysis){
        for(int i=0;i<needAnalysis.size();++i){
            patient.addAnalysisResults(needAnalysis.get(i));
        }
    }

}
