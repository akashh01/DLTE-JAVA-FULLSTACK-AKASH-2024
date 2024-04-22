package contract.last.bottomup.dto;

import contract.last.bottomup.User;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private interface QNames {
        QName getUserRequest = new QName(WSEndpoint.NAMESPACE_URI, "getUserRequest");
        QName getUserResponse = new QName(WSEndpoint.NAMESPACE_URI, "getUserResponse");
        QName commonFault = new QName(WSEndpoint.NAMESPACE_URI, "commonFault");
    }

    @XmlElementDecl(namespace = WSEndpoint.NAMESPACE_URI, name = "getUserRequest")
    public JAXBElement<UserPayload> createGetUserRequest(UserPayload value) {
        return new JAXBElement<>(QNames.getUserRequest, UserPayload.class, null, value);
    }

    @XmlElementDecl(namespace = WSEndpoint.NAMESPACE_URI, name = "getUserResponse")
    public JAXBElement<User> createGetUserResponse(User value) {
        return new JAXBElement<>(QNames.getUserResponse, User.class, null, value);
    }

    @XmlElementDecl(namespace = WSEndpoint.NAMESPACE_URI, name = "commonFault")
    public JAXBElement<ErrorResponse> createCommonFault(ErrorResponse value) {
        return new JAXBElement<>(QNames.commonFault, ErrorResponse.class, null, value);
    }

}