package controller.student;

import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Student;

/**
 *
 * @author Linh
 */
@WebServlet(name = "ProfileStudentController", urlPatterns = {"/student/profile_student"})
public class ProfileStudentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("account");

        Student s = Student.builder()
                .StudentEmail(a.getUsername()).build();
        s = new StudentDBContext().getStudentByEmail(s);
        request.setAttribute("s", s);
        request.getRequestDispatcher("../view/student/profile_student.jsp").forward(request, response);
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
