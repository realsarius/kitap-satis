package entity;

public class Kitap {
    

    private int kitapId;
    private String kitapAdi;
    private String kitapYazari;
    private int kitapSayfaSayisi;
    private String kitapCikisTarihi;
    private String kitapEklenmeTarihi;
    private int kitapStokSayisi;
    private int languageId;

    public Kitap(int kitapId, String kitapAdi, String kitapYazari, int kitapSayfaSayisi, String kitapCikisTarihi, String kitapEklenmeTarihi, int kitapStokSayisi) {
        this.kitapId = kitapId;
        this.kitapAdi = kitapAdi;
        this.kitapYazari = kitapYazari;
        this.kitapSayfaSayisi = kitapSayfaSayisi;
        this.kitapCikisTarihi = kitapCikisTarihi;
        this.kitapEklenmeTarihi = kitapEklenmeTarihi;
        this.kitapStokSayisi = kitapStokSayisi;
    }

    public Kitap() {
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
    
    


    public int getKitapId() {
        return kitapId;
    }

    public void setKitapId(int kitapId) {
        this.kitapId = kitapId;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public void setKitapYazari(String kitapYazari) {
        this.kitapYazari = kitapYazari;
    }

    public int getKitapSayfaSayisi() {
        return kitapSayfaSayisi;
    }

    public void setKitapSayfaSayisi(int kitapSayfaSayisi) {
        this.kitapSayfaSayisi = kitapSayfaSayisi;
    }

    public String getKitapCikisTarihi() {
        return kitapCikisTarihi;
    }

    public void setKitapCikisTarihi(String kitapCikisTarihi) {
        this.kitapCikisTarihi = kitapCikisTarihi;
    }

    public String getKitapEklenmeTarihi() {
        return kitapEklenmeTarihi;
    }

    public void setKitapEklenmeTarihi(String kitapEklenmeTarihi) {
        this.kitapEklenmeTarihi = kitapEklenmeTarihi;
    }

    public int getKitapStokSayisi() {
        return kitapStokSayisi;
    }

    public void setKitapStokSayisi(int kitapStokSayisi) {
        this.kitapStokSayisi = kitapStokSayisi;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "kitapId=" + kitapId +
                ", kitapAdi='" + kitapAdi + '\'' +
                ", kitapYazari='" + kitapYazari + '\'' +
                ", kitapSayfaSayisi=" + kitapSayfaSayisi +
                ", kitapCikisTarihi=" + kitapCikisTarihi +
                ", kitapEklenmeTarihi=" + kitapEklenmeTarihi +
                ", kitapStokSayisi=" + kitapStokSayisi +
                '}';
    }
}
