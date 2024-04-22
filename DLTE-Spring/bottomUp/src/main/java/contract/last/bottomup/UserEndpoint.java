package contract.last.bottomup;

import contract.last.bottomup.dto.ObjectFactory;
import contract.last.bottomup.dto.UserPayload;
import contract.last.bottomup.dto.WSEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class UserEndpoint implements WSEndpoint {
  //  private UserService userService;
    private ObjectFactory objectFactory;
//
//    @Autowired
//    public UserEndpoint(UserService userService) {
//        this.userService = userService;
//        this.objectFactory = new ObjectFactory();
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public JAXBElement<User> getUser(@RequestPayload UserPayload userPayload) {
       // User user = userService.getUser(userPayload.getId());
       // return objectFactory.createGetUserResponse(user);
    }
}