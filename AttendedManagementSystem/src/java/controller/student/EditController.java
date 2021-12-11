package controller.student;

import dal.SemesterDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Semester;
import model.Student;

/**
 *
 * @author Linh
 */
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Semester> list_semester = new ArrayList<>();
        list_semester = new SemesterDBContext().getAll();
        String studentID = request.getParameter("studentID");
        
        Student s = Student.builder()
                .StudentID(studentID).build();
        s = new StudentDBContext().getOne(s);
        
        request.setAttribute("s", s);
        request.setAttribute("list_semester", list_semester);
        request.getRequestDispatcher("../view/student/student_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String studentID = request.getParameter("studentID");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date date = Date.valueOf(request.getParameter("date"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        
        Semester se = Semester.builder().SemesterID(semester).build();
        se = new SemesterDBContext().getOne(se);
        Student s = Student.builder()
                .StudentID(studentID)
                .StudentName(name)
                .StudentImage(image)
                .StudentGender(gender)
                .StudentAddress(address)
                .StudentEmail(email)
                .StudentPhone(phone)
                .StudentDOB(date)
                .SemesterID(se)
                .build();
        
        StudentDBContext db = new StudentDBContext();
        db.update(s);
        response.sendRedirect("student_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
