package Lab7.Zad2;

public class ParyImion
{
    private String imie1;
    private String imie2;

    public ParyImion()
    {
        this.imie1 = "";
        this.imie2 = "";
    }
    public ParyImion(String imie1, String imie2)
    {
        this.imie1 = imie1;
        this.imie2 = imie2;
    }

    public String getImie1() { return imie1; }
    public void setImie1(String imie1) { this.imie1 = imie1; }
    public String getImie2() { return imie2; }
    public void setImie2(String imie2) { this.imie2 = imie2; }
}
