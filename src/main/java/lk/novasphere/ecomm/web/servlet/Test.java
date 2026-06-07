package lk.novasphere.ecomm.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.novasphere.ecomm.user.remote.TestRemote;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet(value = "/test", loadOnStartup = 1)
public class Test extends HttpServlet {

    @EJB(lookup = "java:global/ecomm-user-1.0/TestSessionBean")
    private TestRemote testRemote;

    @Override
    public void init() throws ServletException {
        System.out.println("Test Servlet init...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("E-comm Web module Test<br>");

        testRemote.test();

        InitialContext ctx = null;

    }
}
