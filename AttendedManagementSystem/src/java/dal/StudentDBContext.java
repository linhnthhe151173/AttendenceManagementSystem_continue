package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semester;
import model.Student;

/**
 *
 * @author Linh
 */
public class StudentDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public ArrayList<Student> getStudentByClassID(int ClassID) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select s.*\n"
                    + "from ClassMember c inner join Student s\n"
                    + "on c.StudentID = s.StudentID\n"
                    + "where c.ClassID = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, ClassID);
            rs = stm.executeQuery();

            while (rs.next()) {

                Semester se = Semester.builder().SemesterID(rs.getInt(9)).build();
                se = new SemesterDBContext().getOne(se);

                Student s = Student.builder()
                        .StudentID(rs.getString(1))
                        .StudentName(rs.getString(2))
                        .StudentImage(rs.getString(3))
                        .StudentGender(rs.getBoolean(4))
                        .StudentAddress(rs.getString(5))
                        .StudentEmail(rs.getString(6))
                        .StudentPhone(rs.getString(7))
                        .StudentDOB(rs.getDate(8))
                        .SemesterID(se)
                        .build();

                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Student getOne(Student student) {
        try {
            String sql = "select * from Student\n"
                    + "where StudentID = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, student.getStudentID());
            rs = stm.executeQuery();

            while (rs.next()) {

                Semester se = Semester.builder().SemesterID(rs.getInt(9)).build();
                se = new SemesterDBContext().getOne(se);

                Student s = Student.builder()
                        .StudentID(rs.getString(1))
                        .StudentName(rs.getString(2))
                        .StudentImage(rs.getString(3))
                        .StudentGender(rs.getBoolean(4))
                        .StudentAddress(rs.getString(5))
                        .StudentEmail(rs.getString(6))
                        .StudentPhone(rs.getString(7))
                        .StudentDOB(rs.getDate(8))
                        .SemesterID(se)
                        .build();

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Student s) {
        try {
            String sql = "INSERT INTO [dbo].[Student]\n"
                    + "           ([StudentID]\n"
                    + "           ,[StudentName]\n"
                    + "           ,[StudentImage]\n"
                    + "           ,[StudentGender]\n"
                    + "           ,[StudentAddress]\n"
                    + "           ,[StudentEmail]\n"
                    + "           ,[StudentPhone]\n"
                    + "           ,[StudentDOB]\n"
                    + "           ,[SemesterID])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getStudentID());
            stm.setString(2, s.getStudentName());
            stm.setString(3, s.getStudentImage());
            stm.setBoolean(4, s.isStudentGender());
            stm.setString(5, s.getStudentAddress());
            stm.setString(6, s.getStudentEmail());
            stm.setString(7, s.getStudentPhone());
            stm.setDate(8, s.getStudentDOB());
            stm.setInt(9, s.getSemesterID().getSemesterID());

            rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select * from Student";

            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Semester se = Semester.builder().SemesterID(rs.getInt(9)).build();
                se = new SemesterDBContext().getOne(se);

                Student s = Student.builder()
                        .StudentID(rs.getString(1))
                        .StudentName(rs.getString(2))
                        .StudentImage(rs.getString(3))
                        .StudentGender(rs.getBoolean(4))
                        .StudentAddress(rs.getString(5))
                        .StudentEmail(rs.getString(6))
                        .StudentPhone(rs.getString(7))
                        .StudentDOB(rs.getDate(8))
                        .SemesterID(se)
                        .build();

                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students = new StudentDBContext().getAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void update(Student s) {
        try {
            String sql = "UPDATE [dbo].[Student]\n"
                    + "   SET [StudentID] = ?\n"
                    + "      ,[StudentName] = ?\n"
                    + "      ,[StudentImage] = ?\n"
                    + "      ,[StudentGender] = ?\n"
                    + "      ,[StudentAddress] = ?\n"
                    + "      ,[StudentEmail] = ?\n"
                    + "      ,[StudentPhone] = ?\n"
                    + "      ,[StudentDOB] = ?\n"
                    + "      ,[SemesterID] = ?\n"
                    + " WHERE StudentID = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getStudentID());
            stm.setString(2, s.getStudentName());
            stm.setString(3, s.getStudentImage());
            stm.setBoolean(4, s.isStudentGender());
            stm.setString(5, s.getStudentAddress());
            stm.setString(6, s.getStudentEmail());
            stm.setString(7, s.getStudentPhone());
            stm.setDate(8, s.getStudentDOB());
            stm.setInt(9, s.getSemesterID().getSemesterID());
            stm.setString(10, s.getStudentID());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeStudentByID(String studentID) {
        try {
            String sql = "DELETE FROM [dbo].[Student]\n"
                    + "      WHERE StudentID = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, studentID);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Student> search(String search_code) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "select * from Student\n"
                    + "where StudentID like '%'+?+'%'";

            stm = connection.prepareStatement(sql);
            stm.setString(1, search_code);
            rs = stm.executeQuery();

            while (rs.next()) {

                Semester se = Semester.builder().SemesterID(rs.getInt(9)).build();
                se = new SemesterDBContext().getOne(se);

                Student s = Student.builder()
                        .StudentID(rs.getString(1))
                        .StudentName(rs.getString(2))
                        .StudentImage(rs.getString(3))
                        .StudentGender(rs.getBoolean(4))
                        .StudentAddress(rs.getString(5))
                        .StudentEmail(rs.getString(6))
                        .StudentPhone(rs.getString(7))
                        .StudentDOB(rs.getDate(8))
                        .SemesterID(se)
                        .build();

                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countStudent() {
        int total_schedule = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Student";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                total_schedule = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total_schedule;
    }
}
