package controller.student;

import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author Linh
 */
public class StudentDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ArrayList<Student> list = new ArrayList<>();
        list = new StudentDBContext().getAll();
        
        request.setAttribute("list", list);
        request.getRequestDispatcher("../view/admin/student_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search_code = request.getParameter("search_code");
        
        if(search_code == null){
            search_code = "";
        }

        ArrayList<Student> list_search = new ArrayList<>();
        list_search = new StudentDBContext().search(search_code);
        
        request.setAttribute("list_search", list_search);
        request.getRequestDispatcher("../view/admin/student_detail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
