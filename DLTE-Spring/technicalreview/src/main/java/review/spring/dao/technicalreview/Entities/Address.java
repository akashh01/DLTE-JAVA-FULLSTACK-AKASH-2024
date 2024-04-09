package review.spring.dao.technicalreview.Entities;

public class Address {
    private String houseName;
    private String streetName;
    private String cityName;
    private String stateName;
    private Integer pincode;
    public Address(){}

    public Address(String houseName, String streetName, String cityName, String stateName, Integer pincode) {
        this.houseName = houseName;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.pincode = pincode;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}
