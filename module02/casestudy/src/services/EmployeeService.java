package services;

import commons.ReadFileCSV;
import models.Employee;

import java.util.*;

public class EmployeeService {
    static final String PATH_EMPLOYEE = "D:\\A0920I1_Hoang_Cong_Tu\\casestudy\\src\\data\\employees.csv";

    public static void showEmployee(){

        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<String> listEmployeeString = ReadFileCSV.readFileCSV(PATH_EMPLOYEE);
        List<Employee> employeeList = new ArrayList<>();

        for(int i = 0; i < listEmployeeString.size(); i++){
            Employee employee = new Employee();
            String string = listEmployeeString.get(i);
            String[] parts = string.split(",");
            employee.setName(parts[0]);
            employee.setAge(Integer.parseInt(parts[1]));
            employee.setAddress(parts[2]);

            employeeList.add(employee);
            employeeMap.put(i+100, employee);
        }

        Set<Integer> set = employeeMap.keySet();
        for(Integer key : set){
            System.out.println("Id: " + key + " " + employeeMap.get(key).toString());
        }
        System.out.println("-----------------------------------------------");
    }
}
