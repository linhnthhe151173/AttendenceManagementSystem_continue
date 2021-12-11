package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Class;
import model.Teacher;

/**
 *
 * @author Linh
 */
public class ClassDBContext extends DBContext {

    private PreparedStatement stm;
    private ResultSet rs;

    public Class getOne(Class c) {
        try {
            String sql = "select * from Class\n"
                    + "where ClassID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, c.getClassID());
            rs = stm.executeQuery();

            while (rs.next()) {
                Class cl = Class.builder().ClassID(rs.getInt(1))
                        .ClassName(rs.getString(2)).build();

                return cl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countClass() {
        int total_class = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Class";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                total_class = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total_class;
    }

    public ArrayList<Class> getAll() {
        try {
            ArrayList<Class> list = new ArrayList<>();
            String sql = "select * from Class";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Class c = Class.builder()
                        .ClassID(rs.getInt(1))
                        .ClassName(rs.getString(2))
                        .build();

                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Class> list = new ArrayList<>();
        list = new ClassDBContext().getClassByName("1505");
        for (Class class1 : list) {
            System.out.println(class1);
        }
    }

    public void inert(Class c) {
        try {
            String sql = "INSERT INTO [dbo].[Class]\n"
                    + "           ([ClassName])\n"
                    + "     VALUES (?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, c.getClassName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Class c) {
        try {
            String sql = "UPDATE [dbo].[Class]\n"
                    + "   SET [ClassName] = ?\n"
                    + " WHERE ClassID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, c.getClassName());
            stm.setInt(2, c.getClassID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeClassByID(int classID) {
        try {
            String sql = "DELETE FROM [dbo].[Class]\n"
                    + "      WHERE ClassID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, classID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Class> getClassByName(String search) {
        try {
            ArrayList<Class> list = new ArrayList<>();
            String sql = "select * from Class where ClassName like '%"+search+"%'";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Class c = Class.builder()
                        .ClassID(rs.getInt(1))
                        .ClassName(rs.getString(2))
                        .build();

                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
