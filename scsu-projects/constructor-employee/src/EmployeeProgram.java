/**
This program creates an employee object.
*/

public class EmployeeProgram {
    
    public static void main(String args[]) {
        
        Employee susan = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        Employee mark = new Employee("Mark Jones", 39119, "IT", "Programmer");
        Employee joy = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");
        
        System.out.println(susan.getName() + "\t" + susan.getID() + "\t" + susan.getDepartment() + "\t" + susan.getPosition());
        
        System.out.println(mark.getName() + "\t" + mark.getID() + "\t" + mark.getDepartment() + "\t\t" + mark.getPosition());
        
        System.out.println(joy.getName() + "\t" + joy.getID() + "\t" + joy.getDepartment() + "\t" + joy.getPosition());
    }
}