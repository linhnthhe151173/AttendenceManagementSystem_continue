package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
import model.Schedule;
import model.Student;

/**
 *
 * @author Linh
 */
public class AttendenceDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public void insert(ArrayList<Attendence> list_attendence) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[Attendence]\n"
                    + "           ([StudentID]\n"
                    + "           ,[ScheduleID]\n"
                    + "           ,[Present]\n"
                    + "           ,[AttendenceDate])\n"
                    + "     VALUES\n"
                    + "           (? , ?, ?, ?)";

            for (Attendence a : list_attendence) {
                stm = connection.prepareStatement(sql);
                stm.setString(1, a.getStudentID().getStudentID());
                stm.setInt(2, a.getScheduleID().getScheduleID());
                stm.setBoolean(3, a.isPresent());
                stm.setDate(4, a.getAttendenceDate());
                stm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Attendence> attendeds = new ArrayList<>();
        attendeds = new AttendenceDBContext().getAll();
        for (Attendence attended : attendeds) {
            System.out.println(attended);
        }

    }

    public ArrayList<Attendence> getAttendeds(int scheduleID) {
        ArrayList<Attendence> attendeds = new ArrayList<>();
        try {
            String sql = "select * from Attendence\n"
                    + "where ScheduleID = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, scheduleID);
            rs = stm.executeQuery();

            while (rs.next()) {
                Student s = Student.builder().StudentID(rs.getString(2)).build();
                s = new StudentDBContext().getOne(s);

                Schedule sc = new ScheduleDBContext().getScheduleByID(rs.getInt(3));

                Attendence a = Attendence.builder()
                        .AttendenceID(rs.getInt(1))
                        .StudentID(s)
                        .ScheduleID(sc)
                        .Present(rs.getBoolean(4))
                        .AttendenceDate(rs.getDate(5)).build();

                attendeds.add(a);
            }
            return attendeds;
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Attendence getAttendenceBySIdAndSchID(String studentID, int scheduleID) {
        try {
            String sql = "select * from Attendence\n"
                    + "where StudentID = ? and ScheduleID = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, studentID);
            stm.setInt(2, scheduleID);
            rs = stm.executeQuery();

            while (rs.next()) {
                Student s = Student.builder().StudentID(rs.getString(2)).build();
                s = new StudentDBContext().getOne(s);

                Schedule sc = new ScheduleDBContext().getScheduleByID(rs.getInt(3));

                Attendence a = Attendence.builder()
                        .AttendenceID(rs.getInt(1))
                        .StudentID(s)
                        .ScheduleID(sc)
                        .Present(rs.getBoolean(4))
                        .AttendenceDate(rs.getDate(5)).build();

                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Attendence a, boolean attendence) {
        try {
            String sql = "UPDATE [dbo].[Attendence]\n"
                    + "   SET [Present] = ?\n"
                    + " WHERE AttendenceID = ?";

            stm = connection.prepareStatement(sql);
            stm.setBoolean(1, attendence);
            stm.setInt(2, a.getAttendenceID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Attendence> getAll() {
        ArrayList<Attendence> attendeds = new ArrayList<>();
        try {
            String sql = "select * from Attendence";

            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Student s = Student.builder().StudentID(rs.getString(2)).build();
                s = new StudentDBContext().getOne(s);

                Schedule sc = new ScheduleDBContext().getScheduleByID(rs.getInt(3));

                Attendence a = Attendence.builder()
                        .AttendenceID(rs.getInt(1))
                        .StudentID(s)
                        .ScheduleID(sc)
                        .Present(rs.getBoolean(4))
                        .AttendenceDate(rs.getDate(5)).build();

                attendeds.add(a);
            }
            return attendeds;
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateAttendence(Attendence at) {
        try {
            String sql = "update Attendence\n"
                    + "  set Present = ?\n"
                    + "  where StudentID = ? and ScheduleID = ?";
            stm = connection.prepareStatement(sql);
            stm.setBoolean(1, at.isPresent());
            stm.setString(2, at.getStudentID().getStudentID());
            stm.setInt(3, at.getScheduleID().getScheduleID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int countAttendence() {
        int total_schedule = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Attendence";
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

    public ArrayList<Attendence> getAttendenceOfStudentBySubjectID(Student student, int subjectID) {
        ArrayList<Attendence> attendeds = new ArrayList<>();
        try {
            String sql = "select Attendence.* from Attendence join Schedule\n"
                    + "on Attendence.ScheduleID = Schedule.ScheduleID\n"
                    + "where StudentID = ? and SubjectID = ?";

            stm = connection.prepareStatement(sql);
            stm.setString(1, student.getStudentID());
            stm.setInt(2, subjectID);
            rs = stm.executeQuery();

            while (rs.next()) {
                Student s = Student.builder().StudentID(rs.getString(2)).build();
                s = new StudentDBContext().getOne(s);

                Schedule sc = new ScheduleDBContext().getScheduleByID(rs.getInt(3));

                Attendence a = Attendence.builder()
                        .AttendenceID(rs.getInt(1))
                        .StudentID(s)
                        .ScheduleID(sc)
                        .Present(rs.getBoolean(4))
                        .AttendenceDate(rs.getDate(5)).build();

                attendeds.add(a);
            }
            return attendeds;
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
