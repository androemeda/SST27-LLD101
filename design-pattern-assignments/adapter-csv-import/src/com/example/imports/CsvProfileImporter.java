package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter {

    NaiveCsvReader ncr;
    ProfileService ps;

    public CsvProfileImporter(NaiveCsvReader ncr , ProfileService ps){
        this.ncr = ncr;
        this.ps = ps;
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> data = ncr.read(csvFile);

        int a = 0;
        int b = 0;

        for(int i=1 ; i<data.size() ; i++){
            try {
                ps.createProfile((data.get(i)[0] != "") ? data.get(i)[0] : null , (data.get(i)[1] != "") ? data.get(i)[1] : null , data.get(i)[2]);
                a++;
            } catch (NullPointerException e) {
                System.out.println("cannot create the user - "+data.get(i)[0]+","+data.get(i)[1]+","+data.get(i)[2]+". Reason : missing required field : "+e.getMessage());
                b++;
            } catch(IllegalArgumentException e){
                System.out.println("cannot create the user - "+data.get(i)[0]+","+data.get(i)[1]+","+data.get(i)[2]+". Reason : illegal argument : "+e.getMessage());
                b++;
            }
        }

        System.out.println("\ncreated "+a+" users");
        System.out.println(b+" rows were invalid");

        return data.size()-1;
    }
}
