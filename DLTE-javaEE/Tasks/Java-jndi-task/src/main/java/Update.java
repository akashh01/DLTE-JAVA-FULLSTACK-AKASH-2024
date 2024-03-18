import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/updateAccount/*")
public class Update extends HttpServlet {
    PreparedStatement preparedStatement;
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context context=new InitialContext();
            Connection connection=null;
            DataSource dataSource = (DataSource)context.lookup("java:/OracleDS");
            connection=dataSource.getConnection();
            String username=req.getParameter("username");
            String email=req.getParameter("email");
            if(username!=null && email!=null){
                String query = "Update user_info set email=? where username=?";
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1,email);
                preparedStatement.setString(2,username);
                int result=preparedStatement.executeUpdate();
                if(result!=0) resp.getWriter().println("Accounts table updated");
                else resp.getWriter().println("Accounts table failed to update");
            }

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
