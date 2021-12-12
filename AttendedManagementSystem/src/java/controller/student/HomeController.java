package controller.student;

import dal.AttendenceDBContext;
import dal.SemesterDBContext;
import dal.StudentDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Attendence;
import model.ClassMember;
import model.Semester;
import model.Student;
import model.Subject;

/**
 *
 * @author Linh
 */
@WebServlet(name = "HomeStudentController", urlPatterns = {"/student/home_student"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account a = (Account) request.getSession().getAttribute("account");

        Student s = Student.builder()
                .StudentEmail(a.getUsername()).build();
        s = new StudentDBContext().getStudentByEmail(s);

        Semester semester = new SemesterDBContext().getSemesterByStudentID(s);

        ArrayList<Subject> list_subject = new ArrayList<>();
        list_subject = new SubjectDBContext().getSubjectBySemester(semester);
        request.setAttribute("semester", semester);
        request.setAttribute("list_subject", list_subject);
        request.getRequestDispatcher("../view/student/home_student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Account a = (Account) request.getSession().getAttribute("account");

        int subjectID = Integer.parseInt(request.getParameter("subjectID"));
        
        Student s = Student.builder()
                .StudentEmail(a.getUsername()).build();
        s = new StudentDBContext().getStudentByEmail(s);

        Semester semester = new SemesterDBContext().getSemesterByStudentID(s);

        ArrayList<Subject> list_subject = new ArrayList<>();
        ArrayList<Attendence> list_attendence = new AttendenceDBContext().getAttendenceOfStudentBySubjectID(s, subjectID);
        list_subject = new SubjectDBContext().getSubjectBySemester(semester);
        request.setAttribute("semester", semester);
        request.setAttribute("list_subject", list_subject);
        request.setAttribute("list_attendence", list_attendence);
        request.getRequestDispatcher("../view/student/home_student.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
