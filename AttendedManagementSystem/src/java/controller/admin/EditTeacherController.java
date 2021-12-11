package controller.admin;

import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;

/**
 *
 * @author Linh
 */
public class EditTeacherController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teacherID = Integer.parseInt(request.getParameter("teacherID"));
        
        Teacher t = Teacher.builder()
                .TeacherID(teacherID).build();
        t = new TeacherDBContext().getOne(t);
        
        request.setAttribute("t", t);
        request.getRequestDispatcher("view/teacher/teacher_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int teacherID = Integer.parseInt(request.getParameter("teacherID"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date date = Date.valueOf(request.getParameter("date"));
        
        Teacher t = Teacher.builder()
                .TeacherID(teacherID)
                .TeacherName(name)
                .TeacherImage(image)
                .TeacherGender(gender)
                .TeacherAddress(address)
                .TeacherEmail(email)
                .TeacherPhone(phone)
                .TeacherDOB(date).build();
        
        TeacherDBContext fb = new TeacherDBContext();
        fb.update(t);
        response.sendRedirect("teacher/teacher_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
