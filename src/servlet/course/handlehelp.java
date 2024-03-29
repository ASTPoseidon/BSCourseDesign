package servlet.course;

import dao.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/handlehelp")
public class handlehelp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("helpid");
        MessageDAO messageDAO = new MessageDAO();
        Boolean ok = messageDAO.changeStatus(Integer.parseInt(id));
        if (ok) {
            response.setStatus(200);
        } else {
            response.setStatus(500);
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>alert('失败');history.back();</script>");
            printWriter.flush();
            printWriter.close();
        }
    }
}
