package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semester;
import model.Student;
import model.Subject;

/**
 *
 * @author Linh
 */
public class SemesterDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public Semester getOne(Semester se) {
        try {
            String sql = "select * from Semester\n"
                    + "where SemesterID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, se.getSemesterID());
            rs = stm.executeQuery();

            while (rs.next()) {

                Semester se1 = Semester.builder().SemesterID(rs.getInt(1))
                        .SemesterName(rs.getString(2)).build();

                return se1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Semester> getAll() {
        try {
            ArrayList<Semester> list = new ArrayList<>();
            String sql = "select * from Semester";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Semester s = Semester.builder()
                        .SemesterID(rs.getInt(1))
                        .SemesterName(rs.getString(2)).build();

                list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Semester getSemesterByStudentID(Student student) {
        try {
            String sql = "select * from Semester inner join Student\n"
                    + "on Semester.SemesterID = Student.SemesterID\n"
                    + "where StudentID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, student.getStudentID());
            rs = stm.executeQuery();
            while (rs.next()) {
                Semester s = Semester.builder()
                        .SemesterID(rs.getInt(1))
                        .SemesterName(rs.getString(2)).build();
                return s;

            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
