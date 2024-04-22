package contract.last.bottomup.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userPayload", propOrder = {
        "id"
})
public class UserPayload {
    @XmlElement(required = true)
    private long id;

    /* getters/setters */
}