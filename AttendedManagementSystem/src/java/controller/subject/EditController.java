package controller.subject;

import dal.SemesterDBContext;
import dal.SubjectDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Semester;
import model.Subject;

/**
 *
 * @author Linh
 */
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Semester> list = new ArrayList<>();
        list = new SemesterDBContext().getAll();
        
        int subjectID = Integer.parseInt(request.getParameter("subjectID"));
        Subject s = Subject.builder()
                .SubjectID(subjectID).build();
        s = new SubjectDBContext().getOne(s);

        request.setAttribute("s", s);
        request.setAttribute("list", list);
        request.getRequestDispatcher("../view/subject/subject_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int subjectID = Integer.parseInt(request.getParameter("subjectID"));
        String subject_code = request.getParameter("subject_code");
        String subject_name = request.getParameter("subject_name");
        int slot = Integer.parseInt(request.getParameter("date"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        
        Semester se = Semester.builder().SemesterID(semester).build();
        
        Subject s = Subject.builder()
                .SubjectID(subjectID)
                .SubjectCode(subject_code)
                .SubjectName(subject_name)
                .TotalSlot(slot)
                .SemesterID(se).build();
        
        SubjectDBContext db = new SubjectDBContext();
        db.update(s);
        response.sendRedirect("../subject_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
