package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Schedule;
import model.Subject;
import model.Teacher;
import model.TimeSlot;

/**
 *
 * @author Linh
 */
public class ScheduleDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public ArrayList<Schedule> getScheduleByDate(Date date, Teacher a) {
        ArrayList<Schedule> listSchedule = new ArrayList<>();
        try {
            String sql = "select Schedule.* from Schedule left join Attendence\n"
                    + "on Schedule.ScheduleID = Attendence.ScheduleID\n"
                    + "where AttendenceID is null and ScheduleDate = ?\n"
                    + "and TeacherID = ?";

            stm = connection.prepareStatement(sql);
            stm.setDate(1, date);
            stm.setInt(2, a.getTeacherID());
            rs = stm.executeQuery();

            while (rs.next()) {

                Teacher t = Teacher.builder().TeacherID(rs.getInt(2)).build();
                t = new TeacherDBContext().getOne(t);

                Subject su = Subject.builder().SubjectID(rs.getInt(3)).build();
                su = new SubjectDBContext().getOne(su);

                model.Class c = model.Class.builder().ClassID(rs.getInt(4)).build();
                c = new ClassDBContext().getOne(c);

                Date dateSchedule = Date.valueOf(rs.getString(6));

                TimeSlot ts = TimeSlot.builder().TimeSlotID(rs.getInt(5)).build();
                ts = new TimeSlotDBContext().getOne(ts);

                Schedule s = Schedule.builder().ScheduleID(rs.getInt(1))
                        .TeacherID(t)
                        .SubjectID(su)
                        .ClassID(c)
                        .TimeSlotID(ts)
                        .ScheduleDate(dateSchedule).build();

                listSchedule.add(s);
            }
            return listSchedule;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Schedule> listSchedule = new ArrayList<>();
        ScheduleDBContext dao = new ScheduleDBContext();

        Teacher teacher = Teacher.builder()
                .TeacherID(1).build();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        listSchedule = dao.getScheduleByDate2(date, teacher);
        for (Schedule schedule : listSchedule) {
            System.out.println(schedule);
        }
    }

    public ArrayList<Schedule> getAll() {
        ArrayList<Schedule> listSchedule = new ArrayList<>();
        try {
            String sql = "select * from Schedule";

            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Teacher t = Teacher.builder().TeacherID(rs.getInt(2)).build();
                t = new TeacherDBContext().getOne(t);

                Subject su = Subject.builder().SubjectID(rs.getInt(3)).build();
                su = new SubjectDBContext().getOne(su);

                model.Class c = model.Class.builder().ClassID(rs.getInt(4)).build();
                c = new ClassDBContext().getOne(c);

                Date dateSchedule = Date.valueOf(rs.getString(6));

                TimeSlot ts = TimeSlot.builder().TimeSlotID(rs.getInt(5)).build();
                ts = new TimeSlotDBContext().getOne(ts);

                Schedule s = Schedule.builder().ScheduleID(rs.getInt(1))
                        .TeacherID(t)
                        .SubjectID(su)
                        .ClassID(c)
                        .TimeSlotID(ts)
                        .ScheduleDate(dateSchedule).build();

                listSchedule.add(s);
            }
            return listSchedule;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Schedule getScheduleByID(int scheduleID) {
        try {
            String sql = "select *\n"
                    + "from Schedule\n"
                    + "where ScheduleID = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, scheduleID);
            rs = stm.executeQuery();

            while (rs.next()) {

                Teacher t = Teacher.builder().TeacherID(rs.getInt(2)).build();
                t = new TeacherDBContext().getOne(t);

                Subject su = Subject.builder().SubjectID(rs.getInt(3)).build();
                su = new SubjectDBContext().getOne(su);

                model.Class c = model.Class.builder().ClassID(rs.getInt(4)).build();
                c = new ClassDBContext().getOne(c);

                Date dateSchedule = Date.valueOf(rs.getString(6));

                TimeSlot ts = TimeSlot.builder().TimeSlotID(rs.getInt(5)).build();
                ts = new TimeSlotDBContext().getOne(ts);

                Schedule s = Schedule.builder()
                        .ScheduleID(rs.getInt(1))
                        .TeacherID(t)
                        .SubjectID(su)
                        .ClassID(c)
                        .TimeSlotID(ts)
                        .ScheduleDate(dateSchedule).build();

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Schedule> getScheduleInAttendence() {
        ArrayList<Schedule> listSchedule = new ArrayList<>();
        try {
            String sql = "select distinct Schedule.* from Attendence\n"
                    + "inner join Schedule on Attendence.ScheduleID = Schedule.ScheduleID";

            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {

                Teacher t = Teacher.builder().TeacherID(rs.getInt(2)).build();
                t = new TeacherDBContext().getOne(t);

                Subject su = Subject.builder().SubjectID(rs.getInt(3)).build();
                su = new SubjectDBContext().getOne(su);

                model.Class c = model.Class.builder().ClassID(rs.getInt(4)).build();
                c = new ClassDBContext().getOne(c);

                Date dateSchedule = Date.valueOf(rs.getString(6));

                TimeSlot ts = TimeSlot.builder().TimeSlotID(rs.getInt(5)).build();
                ts = new TimeSlotDBContext().getOne(ts);

                Schedule s = Schedule.builder().ScheduleID(rs.getInt(1))
                        .TeacherID(t)
                        .SubjectID(su)
                        .ClassID(c)
                        .TimeSlotID(ts)
                        .ScheduleDate(dateSchedule).build();

                listSchedule.add(s);
            }
            return listSchedule;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countSchedule() {
        int total_schedule = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Schedule";
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

    public void insert(Schedule s) {
        try {
            String sql = "INSERT INTO [dbo].[Schedule]\n"
                    + "           ([TeacherID]\n"
                    + "           ,[SubjectID]\n"
                    + "           ,[ClassID]\n"
                    + "           ,[TimeSlotID]\n"
                    + "           ,[ScheduleDate])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, s.getTeacherID().getTeacherID());
            stm.setInt(2, s.getSubjectID().getSubjectID());
            stm.setInt(3, s.getClassID().getClassID());
            stm.setInt(4, s.getTimeSlotID().getTimeSlotID());
            stm.setDate(5, s.getScheduleDate());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Schedule s) {
        try {
            String sql = "UPDATE [dbo].[Schedule]\n"
                    + "   SET [TeacherID] = ?\n"
                    + "      ,[SubjectID] = ?\n"
                    + "      ,[ClassID] = ?\n"
                    + "      ,[TimeSlotID] = ?\n"
                    + "      ,[ScheduleDate] = ?\n"
                    + " WHERE ScheduleID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, s.getTeacherID().getTeacherID());
            stm.setInt(2, s.getSubjectID().getSubjectID());
            stm.setInt(3, s.getClassID().getClassID());
            stm.setInt(4, s.getTimeSlotID().getTimeSlotID());
            stm.setDate(5, s.getScheduleDate());
            stm.setInt(6, s.getScheduleID());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeScheduleByID(int scheduleID) {
        try {
            String sql = "DELETE FROM [dbo].[Schedule]\n"
                    + "      WHERE ScheduleID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, scheduleID);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Schedule> getScheduleByDate2(Date search_date, Teacher teacher) {
        ArrayList<Schedule> listSchedule = new ArrayList<>();
        try {
            String sql = "select * from Schedule where ScheduleDate = ?\n"
                    + "and TeacherID = ?";

            stm = connection.prepareStatement(sql);
            stm.setDate(1, search_date);
            stm.setInt(2, teacher.getTeacherID());
            rs = stm.executeQuery();

            while (rs.next()) {

                Teacher t = Teacher.builder().TeacherID(rs.getInt(2)).build();
                t = new TeacherDBContext().getOne(t);

                Subject su = Subject.builder().SubjectID(rs.getInt(3)).build();
                su = new SubjectDBContext().getOne(su);

                model.Class c = model.Class.builder().ClassID(rs.getInt(4)).build();
                c = new ClassDBContext().getOne(c);

                Date dateSchedule = Date.valueOf(rs.getString(6));

                TimeSlot ts = TimeSlot.builder().TimeSlotID(rs.getInt(5)).build();
                ts = new TimeSlotDBContext().getOne(ts);

                Schedule s = Schedule.builder().ScheduleID(rs.getInt(1))
                        .TeacherID(t)
                        .SubjectID(su)
                        .ClassID(c)
                        .TimeSlotID(ts)
                        .ScheduleDate(dateSchedule).build();

                listSchedule.add(s);
            }
            return listSchedule;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Schedule> getAllScheduleByTeacher(Teacher teacher) {
        ArrayList<Schedule> listSchedule = new ArrayList<>();
        try {
            String sql = "select * from Schedule\n"
                    + "where TeacherID = ?";

            stm = connection.prepareStatement(sql);
            stm.setInt(1, teacher.getTeacherID());
            rs = stm.executeQuery();

            while (rs.next()) {

                Teacher t = Teacher.builder().TeacherID(rs.getInt(2)).build();
                t = new TeacherDBContext().getOne(t);

                Subject su = Subject.builder().SubjectID(rs.getInt(3)).build();
                su = new SubjectDBContext().getOne(su);

                model.Class c = model.Class.builder().ClassID(rs.getInt(4)).build();
                c = new ClassDBContext().getOne(c);

                Date dateSchedule = Date.valueOf(rs.getString(6));

                TimeSlot ts = TimeSlot.builder().TimeSlotID(rs.getInt(5)).build();
                ts = new TimeSlotDBContext().getOne(ts);

                Schedule s = Schedule.builder().ScheduleID(rs.getInt(1))
                        .TeacherID(t)
                        .SubjectID(su)
                        .ClassID(c)
                        .TimeSlotID(ts)
                        .ScheduleDate(dateSchedule).build();

                listSchedule.add(s);
            }
            return listSchedule;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
