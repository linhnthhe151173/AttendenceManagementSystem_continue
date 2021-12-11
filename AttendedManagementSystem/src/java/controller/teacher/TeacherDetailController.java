package controller.teacher;

import dal.StudentDBContext;
import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.Teacher;

/**
 *
 * @author Linh
 */
public class TeacherDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ArrayList<Teacher> list = new ArrayList<>();
        list = new TeacherDBContext().getAll();
        
        request.setAttribute("list", list);
        request.getRequestDispatcher("../view/admin/teacher_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_search = request.getParameter("search");
        boolean raw_gender = Boolean.parseBoolean(request.getParameter("gender"));
        
        if(raw_search == null){
            raw_search = "";
        }
        ArrayList<Teacher> list_search = new TeacherDBContext().search(raw_search, raw_gender);
        request.setAttribute("list_search", list_search);
        request.getRequestDispatcher("../view/admin/teacher_detail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
