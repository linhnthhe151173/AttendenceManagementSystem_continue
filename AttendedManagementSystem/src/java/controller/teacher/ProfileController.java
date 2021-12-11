package controller.teacher;

import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;

/**
 *
 * @author Linh
 */
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teacherID = Integer.parseInt(request.getParameter("teacherID"));
        Teacher t = Teacher.builder()
                .TeacherID(teacherID).build();
        t = new TeacherDBContext().getOne(t);
        
        request.setAttribute("t", t);
        request.getRequestDispatcher("../view/teacher/profile.jsp").forward(request, response);
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
