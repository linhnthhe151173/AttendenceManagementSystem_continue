package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author Linh
 */
public class RoleDBContext extends DBContext{

    private PreparedStatement stm;
    private ResultSet rs;
    
    public Role getOne(Role role) {
        try {
            String sql = "select * from Role\n"
                    + "where RoleID = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, role.getRoleID());
            rs = stm.executeQuery();
            while (rs.next()) {                
                Role r = Role.builder()
                        .RoleID(rs.getInt(1))
                        .RoleName(rs.getString(2)).build();
                
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
