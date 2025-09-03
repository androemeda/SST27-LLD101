package exercise;

import java.util.*;

public class Client {
  public static void main(String[] args) {
    // Sample legacy data from three sources
    List<EmployeeCSV> csvRows = List.of(
      new EmployeeCSV("101,John,Doe,john.doe@acme.com"),
      new EmployeeCSV("102,Sarah,Lee,sarah.lee@acme.com")
    );

    List<EmployeeDB> dbRows = List.of(
      new EmployeeDB(201, "Ravi", "Kumar", "ravi.kumar@contoso.com"),
      new EmployeeDB(202, "Anita", "Sharma", "anita.sharma@contoso.com")
    );

    List<EmployeeLDAP> ldapRows = List.of(
      new EmployeeLDAP(Map.of("uid","301","givenName","Wei","sn","Zhang","mail","wei.zhang@example.org")),
      new EmployeeLDAP(Map.of("uid","302","givenName","Elena","sn","Garcia","mail","elena.garcia@example.org"))
    );

    // Wrap each legacy object with the right adapter and collect into one list
    List<Employee> all = new ArrayList<>();
    
    for (EmployeeCSV csvRow : csvRows) {
      all.add(new EmployeeCSVAdapter(csvRow));
    }
    
    for (EmployeeDB dbRow : dbRows) {
      all.add(new EmployeeDBAdapter(dbRow));
    }
    
    for (EmployeeLDAP ldapRow : ldapRows) {
      all.add(new EmployeeLDAPAdapter(ldapRow));
    }


    EmployeePrinter.print(all);
  }
}
