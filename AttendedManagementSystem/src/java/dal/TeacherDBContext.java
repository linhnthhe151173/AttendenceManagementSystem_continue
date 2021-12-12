package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teacher;

/**
 *
 * @author Linh
 */
public class TeacherDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public Teacher getOne(Teacher t) {
        try {
            String sql = "select * from Teacher\n"
                    + "where TeacherID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, t.getTeacherID());
            rs = stm.executeQuery();

            while (rs.next()) {
                Teacher t1 = Teacher.builder().TeacherID(rs.getInt(1))
                        .TeacherName(rs.getString(2))
                        .TeacherImage(rs.getString(3))
                        .TeacherGender(rs.getBoolean(4))
                        .TeacherAddress(rs.getString(5))
                        .TeacherEmail(rs.getString(6))
                        .TeacherPhone(rs.getString(7))
                        .TeacherDOB(rs.getDate(8)).build();

                return t1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Teacher> getAll() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            String sql = "select * from Teacher";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Teacher t = Teacher.builder()
                        .TeacherID(rs.getInt(1))
                        .TeacherName(rs.getString(2))
                        .TeacherImage(rs.getString(3))
                        .TeacherGender(rs.getBoolean(4))
                        .TeacherAddress(rs.getString(5))
                        .TeacherEmail(rs.getString(6))
                        .TeacherPhone(rs.getString(7))
                        .TeacherDOB(rs.getDate(8)).build();

                teachers.add(t);
            }
            return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Teacher t) {
        try {
            String sql = "INSERT INTO [dbo].[Teacher]\n"
                    + "           ([TeacherName]\n"
                    + "           ,[TeacherImage]\n"
                    + "           ,[TeacherGender]\n"
                    + "           ,[TeacherAddress]\n"
                    + "           ,[TeacherEmail]\n"
                    + "           ,[TeacherPhone]\n"
                    + "           ,[TeacherDOB])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, t.getTeacherName());
            stm.setString(2, t.getTeacherImage());
            stm.setBoolean(3, t.isTeacherGender());
            stm.setString(4, t.getTeacherAddress());
            stm.setString(5, t.getTeacherEmail());
            stm.setString(6, t.getTeacherPhone());
            stm.setDate(7, t.getTeacherDOB());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Teacher t) {
        try {
            String sql = "UPDATE [dbo].[Teacher]\n"
                    + "   SET [TeacherName] = ?\n"
                    + "      ,[TeacherImage] = ?\n"
                    + "      ,[TeacherGender] = ?\n"
                    + "      ,[TeacherAddress] = ?\n"
                    + "      ,[TeacherEmail] = ?\n"
                    + "      ,[TeacherPhone] = ?\n"
                    + "      ,[TeacherDOB] = ?\n"
                    + " WHERE TeacherID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, t.getTeacherName());
            stm.setString(2, t.getTeacherImage());
            stm.setBoolean(3, t.isTeacherGender());
            stm.setString(4, t.getTeacherAddress());
            stm.setString(5, t.getTeacherEmail());
            stm.setString(6, t.getTeacherPhone());
            stm.setDate(7, t.getTeacherDOB());
            stm.setInt(8, t.getTeacherID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeTeacherByID(int teacherID) {
        try {
            String sql = "DELETE FROM [dbo].[Teacher]\n"
                    + "      WHERE TeacherID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, teacherID);

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Teacher getTeacherByEmail(Teacher t) {
        try {
            String sql = "select * from Teacher\n"
                    + "where TeacherEmail = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, t.getTeacherEmail());
            rs = stm.executeQuery();

            while (rs.next()) {
                Teacher t1 = Teacher.builder().TeacherID(rs.getInt(1))
                        .TeacherName(rs.getString(2))
                        .TeacherImage(rs.getString(3))
                        .TeacherGender(rs.getBoolean(4))
                        .TeacherAddress(rs.getString(5))
                        .TeacherEmail(rs.getString(6))
                        .TeacherPhone(rs.getString(7))
                        .TeacherDOB(rs.getDate(8)).build();

                return t1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Teacher> search(String raw_search, boolean raw_gender) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try {
            String sql = "select * from Teacher\n"
                    + "where TeacherGender = ?";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int indexParam = 1;
            if (raw_search != null) {
                sql += " and TeacherName like '%'+?+'%' ";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = String.class.getTypeName();
                params[1] = raw_search;
                parameters.put(indexParam, params);
            }
            stm = connection.prepareStatement(sql);
            stm.setBoolean(1, raw_gender);

            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] params = entry.getValue();
                String type = params[0].toString();
                if (type.equals(Boolean.class.getTypeName())) {
                    stm.setBoolean(index, (Boolean) params[1]);
                } else if (type.equals(String.class.getTypeName())) {
                    stm.setString(index, params[1].toString());
                }
            }

            rs = stm.executeQuery();
            while (rs.next()) {
                Teacher t = Teacher.builder()
                        .TeacherID(rs.getInt(1))
                        .TeacherName(rs.getString(2))
                        .TeacherImage(rs.getString(3))
                        .TeacherGender(rs.getBoolean(4))
                        .TeacherAddress(rs.getString(5))
                        .TeacherEmail(rs.getString(6))
                        .TeacherPhone(rs.getString(7))
                        .TeacherDOB(rs.getDate(8)).build();

                teachers.add(t);
            }
            return teachers;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers = new TeacherDBContext().search("h", true);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public int countTeacher() {
        int total_schedule = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Teacher";
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
