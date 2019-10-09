public class Student extends Person {
  private double gpa;
  private String major;
  private static int STUDENT_ID = 0;
  private int studentID;

  public Student(String name, String address, int age, String phoneNumber, String gender, double gpa, String major) {
    super(name, address, age, phoneNumber, gender);
    this.setGPA(gpa);
    this.setMajor(major);
    this.studentID = Student.STUDENT_ID;
    // get the ID that will be used when another object is created
    Student.getNextStudentID();
  }

  public double getGPA() {
    return this.gpa;
  }

  public void setGPA(double gpa) {
    this.gpa = gpa;
  }

  public String getMajor() {
    return this.major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public void curveGPA(double curveAmount) {
    if (this.getGPA() + curveAmount > 4.0) {
      this.setGPA(4.0);
    } else {
      this.setGPA(this.getGPA() + curveAmount);
    }
  }

  public int getStudentID() {
    return this.studentID;
  }

  public static int getNextStudentID() {
    return Student.STUDENT_ID++;
  }

  @Override
  public String toString() {
    return String.format("%s, Student ID: %d, Major: %s, GPA: %.2f", 
      super.toString(), this.getStudentID(), this.getMajor(), this.getGPA()
    );
  }

  @Override
  public boolean equals(Object o) {
    Student s = (Student) o;
    return (super.equals(s) && this.getGPA() == s.getGPA() && this.getMajor().equals(s.getMajor()));
  }

  public static void main(String[] args) {
    Student s1 = new Student("John", "1234 H street, New York", 21, "555-555-5555", "Male", 3.0, "Arts");
    Student s2 = new Student("Mark", "700 Right Ln, New York", 20, "455-551-7894", "Male", 2.8, "CS");

    s1.getStudentID();
    System.out.printf("Student's name is %s, with %f GPA, and ID# %d\r\n", s1.getName(), s1.getGPA(),
        s1.getStudentID());

    System.out.printf("Student's name is %s, with %f GPA, and ID# %d\r\n", s1.getName(), s1.getGPA(),
        s1.getStudentID());
    System.out.printf("Student's name is %s, with %f GPA, and ID# %d\r\n", s2.getName(), s2.getGPA(),
        s2.getStudentID());
  }
}