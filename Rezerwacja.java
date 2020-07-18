package BL;

import java.util.ArrayList;

public class Rezerwacja {
    public String imie;
    public String nazwisko;
    public String wylotZ;
    public String przylotDo;
    public String selectedVIP;
    public ArrayList<String>selectedPosilek=new ArrayList<>();
    public String uwagi;

    public Rezerwacja(String imie, String nazwisko, String wylotZ, String przylotDo, String selectedVIP, ArrayList<String> selectedPosilek, String uwagi) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wylotZ = wylotZ;
        this.przylotDo = przylotDo;
        this.selectedVIP = selectedVIP;
        this.selectedPosilek = selectedPosilek;
        this.uwagi = uwagi;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getWylotZ() {
        return wylotZ;
    }

    public void setWylotZ(String wylotZ) {
        this.wylotZ = wylotZ;
    }

    public String getPrzylotDo() {
        return przylotDo;
    }

    public void setPrzylotDo(String przylotDo) {
        this.przylotDo = przylotDo;
    }

    public String getSelectedVIP() {
        return selectedVIP;
    }

    public void setSelectedVIP(String selectedVIP) {
        this.selectedVIP = selectedVIP;
    }

    public ArrayList<String> getSelectedPosilek() {
        return selectedPosilek;
    }

    public void setSelectedPosilek(ArrayList<String> selectedPosilek) {
        this.selectedPosilek = selectedPosilek;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    @Override
    public String toString() {
        return imie + "/" + nazwisko + "/" +
               wylotZ + "/" + przylotDo + "/" +
                selectedVIP + "/" +
                selectedPosilek + "/"
                + uwagi + ";";
    }
}
