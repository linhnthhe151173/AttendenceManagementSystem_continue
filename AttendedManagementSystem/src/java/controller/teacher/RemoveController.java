package controller.teacher;

import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Linh
 */
public class RemoveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teacherID = Integer.parseInt(request.getParameter("teacherID"));
        
        TeacherDBContext db = new TeacherDBContext();
        db.removeTeacherByID(teacherID);
        response.sendRedirect("teacher_detail");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
