package servlet.root;

import dao.NoticeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/sendnotice")
public class sendnotice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String content = request.getParameter("content");
        String title = request.getParameter("title");
        NoticeDAO noticeDAO = new NoticeDAO();
        try {
            Boolean ok = noticeDAO.add(content, title);
            if (ok) {
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<script>alert('添加成功！');window.location.href='" + request.getContextPath() + "/page/root/sendnotice.jsp';</script>");
                printWriter.flush();
                printWriter.close();
            } else {
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<script>alert('添加失败！');history.back();</script>");
                printWriter.flush();
                printWriter.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>alert('服务器异常！');history.back();</script>");
            printWriter.flush();
            printWriter.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
