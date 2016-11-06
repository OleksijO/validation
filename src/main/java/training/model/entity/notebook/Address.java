package training.model.entity.notebook;

/**
 * Created by oleksij.onysymchuk@gmail on 06.11.2016.
 */
public class Address {
    public static final String ADDRESS_SEPARATOR = ", ";
    private int id;
    private String index;
    private String city;
    private String street;
    private String house;
    private String apartment;

    public int getId() {
        return id;
    }

    public String getIndex() {
        return index;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getFullAddress() {
        StringBuilder addressBuilder = new StringBuilder();
        addressBuilder.append(index).append(ADDRESS_SEPARATOR);
        addressBuilder.append(city).append(ADDRESS_SEPARATOR);
        addressBuilder.append(street).append(ADDRESS_SEPARATOR);
        addressBuilder.append(house).append(ADDRESS_SEPARATOR);
        addressBuilder.append(apartment);
        return addressBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (house != address.house) return false;
        if (apartment != address.apartment) return false;
        if (index != null ? !index.equals(address.index) : address.index != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return street != null ? street.equals(address.street) : address.street == null;

    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
