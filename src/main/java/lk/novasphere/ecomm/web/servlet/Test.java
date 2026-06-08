package lk.novasphere.ecomm.web.servlet;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/test", loadOnStartup = 1)
public class Test extends HttpServlet {

//    @EJB(lookup = "java:global/ecomm-user-1.0/TestNewSessionBean")
//    private TestRemote testRemote;
//
//    @EJB
//    private AppSetting appSetting;

    @Inject
    private MyApp myApp;


    @Override
    public void init() throws ServletException {
        System.out.println("Test init...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("E-comm Web module Test<br>");

        // req.getSession();

        myApp.doSomething();

        // resp.getWriter().write("App Name: "+appSetting.getName());


    }
}
