package webapp;

import appLayer.User;
import jdbc.signup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.*;


//@WebServlet(name = "login")
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User userObject = new User();
        String loginpwd = request.getParameter("password");
        String generatedPassword = signup.getString(loginpwd);
        String firstname = request.getParameter("first_name");
        String lastname = request.getParameter("last_name");
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        request.setAttribute("username", request.getParameter("login"));
        request.setAttribute("password", generatedPassword);
        String gRecaptchaResponse = request
                .getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);


        if(userObject.isAdmin(request.getParameter("login"), request.getParameter("password")) && verify){
            HttpSession session = request.getSession();
            session.setAttribute("admin", request.getParameter("login"));
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        else if(userObject.isValidUserCredentials(request.getParameter("login"), generatedPassword) && verify){

            HttpSession session = request.getSession();
            session.removeAttribute("admin");
            session.setAttribute("admin", null);
            session.setAttribute("username", request.getParameter("login"));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
            PrintWriter out = response.getWriter();
            if (verify) {
                //out.println("<font color=red>Either user name or password is wrong.</font>");
                request.setAttribute("errorMessage", "Invalid login or password. Try again");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                //out.println("<font color=red>You missed the Captcha.</font>");
                request.setAttribute("errorMessage", "You missed the captcha. Try again");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.print("Login: "+request.getParameter("login")+" Password: "+request.getParameter("password"));

    }
}
