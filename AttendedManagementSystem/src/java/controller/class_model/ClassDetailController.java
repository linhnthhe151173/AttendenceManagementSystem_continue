package controller.class_model;

import dal.ClassDBContext;
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
public class ClassDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ClassID = Integer.parseInt(request.getParameter("ClassID"));
        
        model.Class c = model.Class.builder().ClassID(ClassID).build();
        c = new ClassDBContext().getOne(c);
        
        ArrayList<Student> students = new ArrayList<>();
        StudentDBContext dbStu = new StudentDBContext();
        students = dbStu.getStudentByClassID(ClassID);
        
        request.setAttribute("c", c);
        request.setAttribute("students", students);
        request.getRequestDispatcher("../view/teacher/class_detail.jsp").forward(request, response);
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
