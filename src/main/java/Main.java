import com.cobeliii.Student;
import com.cobeliii.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        studentService.addStudent(new Student("Newton", 22));
        studentService.addStudent(new Student("Water", 23));
        studentService.addStudent(new Student("John", 27));

        System.out.println(studentService.getStudents());
    }
}
