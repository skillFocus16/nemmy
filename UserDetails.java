package namy.healthtrack;

/**
 * Created by BANGALORE on 5/13/2016.
 */
public class UserDetails {

    private String fName,lName,sex,email,password,yob,address,phoneNo;

     public UserDetails() {

    }

    /*public UserDetails(String fName,String lName,String sex,String email,String password,String yob,String address,String phoneNo){
        this.fName=fName;
        this.lName=lName;
        this.sex=sex;
        this.email=email;
        this.password=password;
        this.yob=yob;
        this.address=address;
        this.phoneNo=phoneNo;
    }*/

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
