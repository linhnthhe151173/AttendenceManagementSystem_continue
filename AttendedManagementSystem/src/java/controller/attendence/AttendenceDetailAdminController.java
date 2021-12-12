package controller.attendence;

import controller.teacher.AttendenceController;
import dal.AttendenceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendence;

/**
 *
 * @author Linh
 */
@WebServlet(name = "AttendenceDetailAdminController", urlPatterns = {"/attendence/attendence_detail_admin"})
public class AttendenceDetailAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Attendence> list_attendence = new ArrayList<>();
        list_attendence = new AttendenceDBContext().getAll();
        
        request.setAttribute("list_attendence", list_attendence);
        request.getRequestDispatcher("../view/attendence/attendence_detail_admin.jsp").forward(request, response);
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
