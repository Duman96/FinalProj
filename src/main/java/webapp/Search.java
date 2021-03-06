package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;

//@WebServlet(name = "Search")
public class Search extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            String searchy = request.getParameter("search");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://10.10.3.14:3306/nullteam" +
                    "?verifyServerCertificate=false" +
                    "&useSSL=false" +
                    "&requireSSL=false" +
                    "&useLegacyDatetimeCode=false" +
                    "&amp" +
                    "&serverTimezone=UTC", "nullteam", "helloworld2");

            System.out.println("Profs with this name");
            //String sql = "SELECT * FROM professors WHERE FirstName LIKE '%$search%' OR Surname LIKE '%$search%' OR School LIKE '%$search%' OR Department LIKE '%$search%'";

            String sql = "SELECT * FROM professors WHERE Professor_name='" + searchy + "' OR Professor_surname='" + searchy + "' OR School='" + searchy
                    + "' OR Department='" + searchy + "' OR Professor_name LIKE '"+searchy+"%' OR Professor_surname LIKE '"+searchy+"%'";

            ResultSet rs;
            Statement st;
            String x;
            String ns = null;
            int id = 0;
            st = conn.createStatement();
            rs = st.executeQuery(sql);

//            out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
//            out.println("<head>");
//            out.println("<meta charset=\"utf-8\" />");
//            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />");
//            out.println("<meta name=\"description\" content=\"\" />");
//            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">");
//            out.println("<title>Just App - Landing Page</title>");
//            out.println("<link href=\"http://localhost:8080/assets/css/bootstrap.css\" rel=\"stylesheet\" />");
//            out.println("<link href=\"http://localhost:8080/assets/css/ionicons.css\" rel=\"stylesheet\" />");
//            out.println("<link href=\"http://localhost:8080/assets/css/style.css\" rel=\"stylesheet\" />");
//            out.println("<script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>");
//            out.println("<script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>");
//            out.println("</head>");
//            out.println("<body bgcolor=\"white\">");
//            out.println("<div class=\"navbar navbar-default navbar-fixed-top scroll-me\">");
//            out.println("<div class=\"container\">");
//            out.println("<div class=\"navbar-header\">");
//            out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">");
//            out.println("<span class=\"icon-bar\"></span>");
//            out.println("<span class=\"icon-bar\"></span>");
//            out.println("<span class=\"icon-bar\"></span>");
//            out.println("</button>");
//            out.println("<a class=\"navbar-brand\" href=\"http://localhost:8080/index.jsp\"> <strong>NULL</strong> </a>");
//            out.println("</div>");
//            out.println("<div class=\"navbar-collapse collapse\">");
//            out.println("<ul class=\"nav navbar-nav navbar-right\">");
//            out.println("<li><a class=\"nav-bar-a\"href=\"http://localhost:8080/profs.jsp\">PROFESSOR</a></li>\n" +
//                    "                <li><a class=\"nav-bar-a\"href=\"#features\">COURSES</a></li>\n" +
//                    "                <li><a class=\"nav-bar-a\"href=\"http://localhost:8080/about_us.jsp\">ABOUT US</a></li>\n" +
//                    "                <li><a class=\"nav-bar-user-a\" href=\"http://localhost:8080/rest/profile/\">PROFILE</a></li>\n" +
//                    "                <li><a class=\"nav-bar-user-a\" href=\"http://localhost:8080/logout\">LOG OUT</a></li>");
//            out.println("</ul> </div> </div> </div>");
//            out.println("<section id=\"about\">\n" +
//                    "    <div class=\"container\">\n" +
//                    "        <div class=\"row scroll-me\">\n" +
//                    "            <center>\n" +
//                    "                <div class=\"col-md-12\">\n" +
//                    "                    <h4>Search Professor</h4>\n" +
//                    "\n" +
//                    "                    <!--<input class=\"search_inputtt\" placeholder=\"  Search...\" type=\"text\" name=\"search\" /></li>-->\n" +
//                    "                    <form class=\"search_inputtt\" action=\"http://localhost:8080/Search\" method=\"post\">\n" +
//                    "                        <p>\n" +
//                    "                            <input class=\"search_input\" placeholder=\" Search...\" type=\"text\" name=\"search\" required/>\n" +
//                    "                            <button type=\"submit\" class=\"nav-bar-a\" name=\"submit\">SUBMIT</button>\n" +
//                    "                        </p>\n" +
//                    "                    </form>\n" +
//                    "                </div>\n" +
//                    "            </center>\n" +
//                    "        </div><br>\n" +
//                    "    </div>\n" +
//                    "</section>\n");
//
//            out.println("");
//            out.println("");
//            out.println("");
//
//            out.println("<title>Hola</title>");


            out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
            out.println("<head>\n" +
                    "    <meta charset=\"utf-8\" />\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n" +
                    "    <meta name=\"description\" content=\"\" />\n" +
                    "    <meta name=\"author\" content=\"\" />\n" +
                    "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n" +
                    "    <title>Just App - Landing Page</title>\n" +
                    "    <link href=\"http://localhost:8080/assets/css/bootstrap.css\" rel=\"stylesheet\" />\n" +
                    "    <link href=\"http://localhost:8080/assets/css/ionicons.css\" rel=\"stylesheet\" />\n" +
                    "    <link href=\"http://localhost:8080/assets/css/style.css\" rel=\"stylesheet\" />\n" +
                    "        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n" +
                    "        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n" +
                    "</head>");
            out.println("<body>");
            out.println(" <div class=\"navbar navbar-default navbar-fixed-top scroll-me\">\n" +
                    "        <!-- pass scroll-me class above a tags to starts scrolling -->\n" +
                    "        <div class=\"container\">\n" +
                    "            <div class=\"navbar-header\">\n" +
                    "                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" +
                    "                    <span class=\"icon-bar\"></span>\n" +
                    "                    <span class=\"icon-bar\"></span>\n" +
                    "                    <span class=\"icon-bar\"></span>\n" +
                    "                </button>\n" +
                    "                <a class=\"navbar-brand\" href=\"index.html\">\n" +
                    "                 <strong>NULL</strong>   \n" +
                    "                </a>\n" +
                    "\n" +
                    "            </div>\n" +
                    "            <div class=\"navbar-collapse collapse\">\n" +
                    "                <ul class=\"nav navbar-nav navbar-right\">\n" +
                    "\n" +
                    "                    <li><a class=\"nav-bar-a\"href=\"profs.jsp\">PROFESSOR</a></li>\n" +
                    "                    <li><a class=\"nav-bar-a\"href=\"#features\">COURSES</a></li>\n" +
                    "                    <li><a class=\"nav-bar-a\"href=\"about_us.jsp\">ABOUT US</a></li>\n" +
                    "                    <li><a class=\"nav-bar-user-a\" href=\"profile_s.html\">PROFILE</a></li>\n" +
                    "                    <li><a class=\"nav-bar-user-a\" href=\"logout\">LOG OUT</a></li>\n" +
                    "                </ul>\n" +
                    "            </div>\n" +
                    "\n" +
                    "        </div>\n" +
                    "    </div>");
            out.println("<section id=\"about\">\n" +
                    "        <div class=\"container\">\n" +
                    "<!--SEARCH INPUT-->\n" +
                    "    <div class=\"row scroll-me\">\n" +
                    "        <div class=\"col-md-12\">\n" +
                    "            <center>\n" +
                    "            <h4>Search Professor</h4>\n" +
                    "            <div class=\"box\">\n" +
                    "              <div class=\"container-4\">\n" +
                    "               <form action=\"/Search\" method=\"post\">"+
                    "                <input type=\"search\" id=\"search\" placeholder=\"Search...\" />\n" +
                    "                <button class=\"icon\">Search</button>\n" +
                    "               </form>"+
                    "              </div>\n" +
                    "            </div>" +
                    "    </div>\n" +
                    "    </div><br>\n" +
                    "        </div>\n" +
                    "</section>");



            int count = 0;
            while(rs.next()){

                count ++;
                id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String surname = rs.getString(3);

                ns = name + " " + surname;
                String pos = rs.getString(6);
                String school = rs.getString(4);
                String dept = rs.getString(5);

                String imgsrc = "data:image/jpg;base64,";
                String ref = "http://localhost:8080/rest/professors/" + id;
                //out.println("<h1> TOTAL NAME IS: <a href = " + ref + ">" + ns + "</a></h1> ");
                out.println("<section id=\"about\">\n" +
                        "    <div class=\"container\">\n" +
                        "        <div class=\"row scroll-me\">\n" +
                        "            <center>\n" +
                        "                <div class=\"col-md-12\">\n" +
                        "                    <h1><a href = " + ref + ">" + ns + "</a></h1>\n" +
                                            "<h2>" + pos + ", " + dept + ", " + school + "</h2>\n" +
                                            //"<img src=\"http://localhost:8080/assets/profpic/" + id + ".jpg\"" + " class=\"prof_img\">" +
                        "                </div>\n" +
                        "            </center>\n" +
                        "        </div><br>\n" +
                        "    </div>\n" +
                        "</section>");


            }
            out.println("<div class=\"footer\">\n" +
                    "    <center>\n" +
                    "        <b>Designed by NULL TM </b> <br>\n" +
                    "    </center>\n" +
                    "</div>\n" +
                    "<script src=\"assets/js/jquery-1.11.1.js\"></script>\n" +
                    "<script src=\"assets/js/bootstrap.js\"></script>\n" +
                    "<script src=\"assets/js/jquery.easing.min.js\"></script>\n" +
                    "<script src=\"assets/js/custom.js\"></script>\n" +
                    "</body>\n" +
                    "</html>");
            System.out.println(count);


        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException sx){
            sx.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
