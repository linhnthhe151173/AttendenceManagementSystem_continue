package controller.teacher;

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
import model.Teacher;

/**
 *
 * @author Linh
 */
public class AddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        request.setAttribute("total_teacher", total_teacher);
        request.setAttribute("total_student", total_student);
        request.setAttribute("total_attendence", total_attendence);
        request.getRequestDispatcher("../view/admin/add_teacher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String teacher_name = request.getParameter("teacher_name");
        String teacher_image = request.getParameter("teacher_image");
        boolean teacher_gender = Boolean.parseBoolean(request.getParameter("teacher_gender"));
        String teacher_adress = request.getParameter("teacher_adress");
        String teacher_email = request.getParameter("teacher_email");
        String teacher_phone = request.getParameter("teacher_phone");
        Date teacher_dob = Date.valueOf(request.getParameter("teacher_dob"));
        
        Teacher t = Teacher.builder()
                .TeacherName(teacher_name)
                .TeacherImage(teacher_image)
                .TeacherGender(teacher_gender)
                .TeacherAddress(teacher_adress)
                .TeacherEmail(teacher_email)
                .TeacherPhone(teacher_phone)
                .TeacherDOB(teacher_dob).build();
        
        TeacherDBContext dbT = new TeacherDBContext();
        dbT.insert(t);
        response.sendRedirect("teacher_detail");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
