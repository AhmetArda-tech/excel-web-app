package com.arda.excelbaskent;

public class Ogrenci {

    private String isim;
    private double toplamNet;
    private double turkceNet;
    private double matNet;
    private double fenNet;
    private double sosyalNet;
    private double ingilizceNet;
    private double dnNet;

       public Ogrenci(String isim, double toplamNet, double matNet, double fenNet, double turkceNet, double sosyalNet, double dnNet, double ingilizceNet){
        this.isim = isim;
        this.toplamNet = toplamNet;
        this.ingilizceNet = ingilizceNet;
        this.matNet = matNet;
        this.sosyalNet = sosyalNet;
        this.turkceNet = turkceNet;
        this.fenNet = fenNet;
        this.dnNet = dnNet;

       }
    
    public String getIsim(){
        return isim;
    }

    public double getNet(){
        return toplamNet;
    }

    public double getmatNet(){
        return matNet;
    }

    public double getfenNet(){
        return fenNet;
    }

    public double getingilizceNet(){
        return ingilizceNet;
    }    

    public double getturkNet(){
        return turkceNet;
    }

    public double getsosyalNet(){
        return sosyalNet;
    }

    public double getdnNet(){
        return dnNet;
    }    

    public void setIsim(String isim){
        this.isim = isim;
    }

    public void setNet(double toplamNet){
        this.toplamNet = toplamNet;
    }

    public void setmatNet(double matNet){
        this.matNet = matNet;
    }
    
    public void setfenNet(double fenNet){
        this.fenNet = fenNet;
    }
    
    public void setingilizceNet(double ingilizceNet){
        this.ingilizceNet = ingilizceNet;
    }
    
    public void setturkNet(double turkceNet){
        this.turkceNet = turkceNet;
    }    

    public void setsosyalNet(double sosyalNet){
        this.sosyalNet = sosyalNet;
    }

    public void setdnNet(double dnNet){
        this.dnNet = dnNet;
    }    

    @Override
    public String toString() {
    return "Öğrenci: " + isim + " - Toplam Net: " + toplamNet;
    }


}
