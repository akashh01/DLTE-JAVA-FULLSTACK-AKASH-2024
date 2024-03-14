import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Integer;
@WebServlet("/types")
public class PrimitiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context context=new InitialContext();
            String role = (String)context.lookup("java:/MyPOC");
            resp.getWriter().println(role);
            Integer number = (Integer) context.lookup("java:/MyNumber");
            resp.getWriter().println(number);
        } catch (NamingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}