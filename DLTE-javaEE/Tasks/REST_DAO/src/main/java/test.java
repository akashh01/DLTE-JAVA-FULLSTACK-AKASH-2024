import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {

        public static void main(String[] args) {
            StorageTarget storageTarget = new DatabaseTarget();
            UserInfoServices userInfoServices = new UserInfoServices(storageTarget);
            // if(req.getParameter("username")!=null&&req.getParameter("date")!=null){
            List<List> transactions = new ArrayList<>();
            transactions = userInfoServices.callTransactionByDate("Eeksha", "13-03-2024");
            System.out.println(transactions.size());
        }
    }

