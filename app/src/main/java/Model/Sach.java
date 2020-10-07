package Model;

public class Sach {
   public String maSach,maTheLoai,tacGia,NXB;
  public   int soLuong;
    public  Double giaBan;


    public Sach() {
    }

    public Sach(String maSach, String maTheLoai, String tacGia, String NXB, int soLuong, Double giaBan) {
        this.maSach = maSach;
        this.maTheLoai = maTheLoai;
        this.tacGia = tacGia;
        this.NXB = NXB;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }
}
