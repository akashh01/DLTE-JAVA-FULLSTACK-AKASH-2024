package rest.console.app.web.servlet;


import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;
import oracle.jdbc.driver.OracleDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;

@WebServlet("/login")
public class AuthenticateServlet extends HttpServlet {
    public UserInfoServices accountService;
    public ResourceBundle resourceBundle;

    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget = new DatabaseTarget();
        accountService = new UserInfoServices(storageTarget);
        resourceBundle = ResourceBundle.getBundle("application");
//        logger= LoggerFactory.getLogger(ReadByIdService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(resourceBundle.getString("db.url"), resourceBundle.getString("db.user"), resourceBundle.getString("db.pass"));
            String query = "select * from my_bank where username=? and password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                HttpSession session=req.getSession();
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                resp.sendRedirect("dashboard.jsp");
            }
            else{
                resp.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            SQLException sqlException = e;
            System.out.println(sqlException);
        }
    }
}