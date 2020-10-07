package Model;

public class NguoiDung {
    public String userName,
        passWord,
        hoTen,
        phone;

    public NguoiDung(String userName, String passWord, String hoTen,String phone) {
        this.userName = userName;
        this.passWord = passWord;
        this.hoTen = hoTen;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public NguoiDung() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }


}
