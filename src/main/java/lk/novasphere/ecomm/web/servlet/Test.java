package lk.novasphere.ecomm.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.novasphere.ecomm.user.dto.UserDTO;
import lk.novasphere.ecomm.user.remote.TestRemote;
import lk.novasphere.ecomm.user.remote.UserRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("E-comm Web module test.<br>");

        try {
            InitialContext ic = new InitialContext();
            TestRemote tr = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");

            String test = tr.test();
            resp.getWriter().write("Result" + test);

//            List<UserDTO> allUsers = userRemote.getAllUsers();
//            for (UserDTO user : allUsers) {
//                user.toString();
//            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
