package contract.last.bottomup;


import contract.last.bottomup.dto.WSEndpoint;
import sun.java2d.cmm.Profile;

import javax.xml.bind.annotation.*;
import java.sql.Date;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
        "id",
        "name",
        "email",
        "registrationDate",
        "profiles"
})
public class User {
    @XmlElement(required = true)
    private Long id;

    @XmlElement
    private String name;

    @XmlElement(required = true)
    private String email;

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    private Date registrationDate;

    @XmlTransient
    private Date removalDate;

    @XmlElement
    @XmlSchemaType(name = "profile", namespace = WSEndpoint.NAMESPACE_URI)
    private Set<Profile> profiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRemovalDate() {
        return removalDate;
    }

    public void setRemovalDate(Date removalDate) {
        this.removalDate = removalDate;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }
}