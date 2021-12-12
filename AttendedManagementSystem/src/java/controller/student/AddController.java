package controller.student;

import dal.AccountDBContext;
import dal.AttendenceDBContext;
import dal.ClassDBContext;
import dal.ScheduleDBContext;
import dal.SemesterDBContext;
import dal.StudentDBContext;
import dal.SubjectDBContext;
import dal.TeacherDBContext;
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
public class AddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Semester> list_semester = new ArrayList<>();
        list_semester = new SemesterDBContext().getAll();
        int total_subject = new SubjectDBContext().countSubject();
        
        int total_class = new ClassDBContext().countClass();
        
        int total_account = new AccountDBContext().countAccount();
        
        int total_schedule = new ScheduleDBContext().countSchedule();
        
        int total_teacher = new TeacherDBContext().countTeacher();
        
        int total_student = new StudentDBContext().countStudent();
        
        int total_attendence = new AttendenceDBContext().countAttendence();
        request.setAttribute("total_subject", total_subject);
        request.setAttribute("total_class", total_class);
        request.setAttribute("total_account", total_account);
        request.setAttribute("total_schedule", total_schedule);
        request.setAttribute("list_semester", list_semester);
        request.setAttribute("total_teacher", total_teacher);
        request.setAttribute("total_student", total_student);
        request.setAttribute("total_attendence", total_attendence);
        request.getRequestDispatcher("../view/admin/add_student.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String student_code = request.getParameter("student_code");
        String student_name = request.getParameter("student_name");
        String student_image = request.getParameter("student_image");
        boolean student_gender = Boolean.parseBoolean(request.getParameter("student_gender"));
        String student_address = request.getParameter("student_address");
        String student_email = request.getParameter("student_email");
        String student_phone = request.getParameter("student_phone");
        Date student_dob = Date.valueOf(request.getParameter("student_dob"));
        int student_semester = Integer.parseInt(request.getParameter("student_semester"));
        
        Semester se = Semester.builder()
                .SemesterID(student_semester).build();
        se = new SemesterDBContext().getOne(se);
        
        Student s = Student.builder()
                .StudentID(student_code)
                .StudentName(student_name)
                .StudentImage(student_image)
                .StudentGender(student_gender)
                .StudentAddress(student_address)
                .StudentEmail(student_email)
                .StudentPhone(student_phone)
                .StudentDOB(student_dob)
                .SemesterID(se).build();
        
        StudentDBContext dbStu = new StudentDBContext();
        dbStu.insert(s);
        response.sendRedirect("student_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
