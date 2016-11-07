package training.model.entity.notebook;

import java.util.Date;

/**
 * This class represents entity of a record in old notebook
 *
 * @author oleksij.onysymchuk@gmail
 * @version 7 NOV 2016
 */
public class Record {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String lastNameAndInitials;
    private String nickName;
    private String comment;
    private Group group;
    private String homePhone;
    private String mobilePhone;
    private String mobilePhone2;
    private String email;
    private String skype;
    private Address address;
    private String fullAddress;
    private Date creationDate;
    private Date lastModifiedDate;

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastNameAndInitials() {
        return lastNameAndInitials;
    }

    public String getNickName() {
        return nickName;
    }

    public String getComment() {
        return comment;
    }

    public Group getGroup() {
        return group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getMobilePhone2() {
        return mobilePhone2;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public Address getAddress() {
        return address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastNameAndInitials(String lastNameAndInitials) {
        this.lastNameAndInitials = lastNameAndInitials;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setMobilePhone2(String mobilePhone2) {
        this.mobilePhone2 = mobilePhone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (id != record.id) return false;
        if (lastName != null ? !lastName.equals(record.lastName) : record.lastName != null) return false;
        if (firstName != null ? !firstName.equals(record.firstName) : record.firstName != null) return false;
        if (middleName != null ? !middleName.equals(record.middleName) : record.middleName != null) return false;
        if (lastNameAndInitials != null ? !lastNameAndInitials.equals(record.lastNameAndInitials) : record.lastNameAndInitials != null)
            return false;
        if (nickName != null ? !nickName.equals(record.nickName) : record.nickName != null) return false;
        if (comment != null ? !comment.equals(record.comment) : record.comment != null) return false;
        if (group != record.group) return false;
        if (homePhone != null ? !homePhone.equals(record.homePhone) : record.homePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(record.mobilePhone) : record.mobilePhone != null) return false;
        if (mobilePhone2 != null ? !mobilePhone2.equals(record.mobilePhone2) : record.mobilePhone2 != null)
            return false;
        if (email != null ? !email.equals(record.email) : record.email != null) return false;
        if (skype != null ? !skype.equals(record.skype) : record.skype != null) return false;
        if (address != null ? !address.equals(record.address) : record.address != null) return false;
        if (fullAddress != null ? !fullAddress.equals(record.fullAddress) : record.fullAddress != null) return false;
        if (creationDate != null ? !creationDate.equals(record.creationDate) : record.creationDate != null)
            return false;
        return lastModifiedDate != null ? lastModifiedDate.equals(record.lastModifiedDate) : record.lastModifiedDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastNameAndInitials != null ? lastNameAndInitials.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone2 != null ? mobilePhone2.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (skype != null ? skype.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (fullAddress != null ? fullAddress.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastNameAndInitials='" + lastNameAndInitials + '\'' +
                ", nickName='" + nickName + '\'' +
                ", comment='" + comment + '\'' +
                ", group=" + group +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", mobilePhone2='" + mobilePhone2 + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", fullAddress='" + fullAddress + '\'' +
                ", creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
