package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Semester;
import model.Subject;

/**
 *
 * @author Linh
 */
public class SubjectDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public Subject getOne(Subject su) {
        try {
            String sql = "select * from Subject\n"
                    + "where SubjectID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, su.getSubjectID());
            rs = stm.executeQuery();

            while (rs.next()) {

                Semester se = Semester.builder().SemesterID(rs.getInt(4)).build();
                se = new SemesterDBContext().getOne(se);

                Subject s = Subject.builder().SubjectID(rs.getInt(1))
                        .SubjectCode(rs.getString(2))
                        .TotalSlot(rs.getInt(3))
                        .SemesterID(se)
                        .SubjectName(rs.getString(5))
                        .build();
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countSubject() {
        int total_subject = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Subject";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                total_subject = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total_subject;
    }

    public ArrayList<Subject> getAll() {
        try {
            ArrayList<Subject> list = new ArrayList<>();
            String sql = "select * from Subject";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Semester se = Semester.builder()
                        .SemesterID(rs.getInt(4)).build();
                se = new SemesterDBContext().getOne(se);

                Subject s = Subject.builder()
                        .SubjectID(rs.getInt(1))
                        .SubjectCode(rs.getString(2))
                        .TotalSlot(rs.getInt(3))
                        .SemesterID(se)
                        .SubjectName(rs.getString(5))
                        .build();

                list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Subject s) {
        try {
            String sql = "INSERT INTO [dbo].[Subject]\n"
                    + "           ([SubjectCode]\n"
                    + "           ,[TotalSlot]\n"
                    + "           ,[SemesterID]\n"
                    + "           ,[SubjectName])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getSubjectCode());
            stm.setInt(2, s.getTotalSlot());
            stm.setInt(3, s.getSemesterID().getSemesterID());
            stm.setString(4, s.getSubjectName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Subject s) {
        try {
            String sql = "UPDATE [dbo].[Subject]\n"
                    + "   SET [SubjectCode] =?\n"
                    + "      ,[TotalSlot] = ?\n"
                    + "      ,[SemesterID] = ?\n"
                    + "      ,[SubjectName] = ?\n"
                    + " WHERE SubjectID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, s.getSubjectCode());
            stm.setInt(2, s.getTotalSlot());
            stm.setInt(3, s.getSemesterID().getSemesterID());
            stm.setString(4, s.getSubjectName());
            stm.setInt(5, s.getSubjectID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeSubjectByID(int subjectID) {
        try {
            String sql = "DELETE FROM [dbo].[Subject]\n"
                    + "      WHERE SubjectID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, subjectID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Subject> searchBySubjectID(String search) {
        try {
            ArrayList<Subject> list = new ArrayList<>();
            String sql = "select * from Subject\n"
                    + "where SubjectCode like '%"+search+"%'";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Semester se = Semester.builder()
                        .SemesterID(rs.getInt(4)).build();
                se = new SemesterDBContext().getOne(se);

                Subject s = Subject.builder()
                        .SubjectID(rs.getInt(1))
                        .SubjectCode(rs.getString(2))
                        .TotalSlot(rs.getInt(3))
                        .SemesterID(se)
                        .SubjectName(rs.getString(5))
                        .build();

                list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Subject> list = new ArrayList<>();
        list = new SubjectDBContext().searchBySubjectID("p");
        for (Subject subject : list) {
            System.out.println(subject);
        }
    }
}
