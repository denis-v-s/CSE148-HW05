/**
 * Faculty
 */
public class Faculty extends Person {
  private static int EMPLOYEE_ID = 0;
  private int employeeId;
  private String department;

  public Faculty(String name, String address, int age, String phoneNumber, String gender, String department) {
    super(name, address, age, phoneNumber, gender);
    this.setDepartment(department);
    this.employeeId = Faculty.EMPLOYEE_ID;
    this.employeeId = this.getNextEmployeeID();
  }

  public int getEmployeeID() {
    return this.employeeId;
  }

  private int getNextEmployeeID() {
    return Faculty.EMPLOYEE_ID++;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public boolean equals(Object o) {
    Faculty f = (Faculty) o;
    return (
      super.equals(f) && 
      this.getEmployeeID() == f.getEmployeeID() &&
      this.getDepartment().equals(f.getDepartment())
    );
  }

  @Override
  public String toString() {
    return super.toString() + ", Employee ID: " + this.getEmployeeID() + ", Department: " + this.getDepartment();
  }
}