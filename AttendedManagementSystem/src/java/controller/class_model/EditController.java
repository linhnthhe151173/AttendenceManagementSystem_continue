package controller.class_model;

import dal.ClassDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Linh
 */
@WebServlet(name = "EditClassController", urlPatterns = {"/class/edit"})
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int classID = Integer.parseInt(request.getParameter("classID"));
        
        model.Class c = model.Class.builder()
                .ClassID(classID).build();
        c = new ClassDBContext().getOne(c);
        
        request.setAttribute("c", c);
        request.getRequestDispatcher("../view/admin/class_edit.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int classID = Integer.parseInt(request.getParameter("classID"));
        String class_name = request.getParameter("class_name");
        
        model.Class c = model.Class.builder()
                .ClassID(classID)
                .ClassName(class_name).build();
        
        ClassDBContext db = new ClassDBContext();
        db.update(c);
        response.sendRedirect("../class_detail");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
