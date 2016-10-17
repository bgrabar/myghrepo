/**
This class creates an employee object.
*/

public class Employee {
    
    private String name, department, position;
    private int idNumber;
    
    public Employee(String n, int id, String dept, String pos) {
        name = n;
        idNumber = id;
        department = dept;
        position = pos;
        }

    public Employee(String n, int id) {
        name = n;
        idNumber = id;
//        department = "";
  //      position = "";
        }

    public Employee() {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
        }
    
    public void setName(String n) {
        name = n;
    }
    
    public void setDepartment(String dept) {
        department = dept;
    }
    
    public void setPosition(String pos) {
        position = pos;
    }
    
    public void setID(int id) {
        idNumber = id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getPosition() {
        return position;
    }
    
    public Integer getID() {
        return idNumber;
    }
}