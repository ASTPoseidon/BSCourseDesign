package servlet.root;

import bean.Notice;
import dao.NoticeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/searchnotice")
public class searchnotice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        NoticeDAO noticeDAO = new NoticeDAO();
        try {
            List<Notice> result = noticeDAO.SelectById(Integer.parseInt(id));
            request.setAttribute("noticelist", result);
            request.getRequestDispatcher("page/student/noticedetail.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>alert('服务器异常！');history.back();</script>");
            printWriter.flush();
            printWriter.close();
        }
    }
}
