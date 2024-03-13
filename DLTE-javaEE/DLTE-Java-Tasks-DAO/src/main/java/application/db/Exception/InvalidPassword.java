package application.db.Exception;

import java.util.ResourceBundle;

public class InvalidPassword extends RuntimeException {
  public InvalidPassword(){
      super(ResourceBundle.getBundle("userinformation").getString("user.password"));
  }


}
