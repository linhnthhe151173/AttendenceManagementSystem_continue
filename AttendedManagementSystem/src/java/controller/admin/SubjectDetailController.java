package controller.admin;

import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Subject;

/**
 *
 * @author Linh
 */
public class SubjectDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Subject> list_subject = new ArrayList<>();
        list_subject = new SubjectDBContext().getAll();
        
        request.setAttribute("list_subject", list_subject);
        request.getRequestDispatcher("view/admin/subject_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        
        if(search == null){
            search = "";
        }
        ArrayList<Subject> subjects = new SubjectDBContext().searchBySubjectID(search);
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("view/admin/subject_detail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
