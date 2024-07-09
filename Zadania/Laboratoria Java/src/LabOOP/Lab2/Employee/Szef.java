package LabOOP.Lab2.Employee;

public class Szef extends Pracownik
{
    private int premia;

    public Szef() {}
    public Szef(String imie, String nazwisko, int wyplata, int premia)
    {
        super(imie, nazwisko, wyplata);
        this.premia = premia;
    }

    public int getPremia() { return premia; }
    public void setPremia(int premia) { this.premia = premia; }

    public void wypisz()
    {
        System.out.print("\nJestem szefem, moje dane: \t\t\t\t\tImie: " + getImie() + "\t\tNazwisko: " + getNazwisko() + " \t\tWyplata: " + getWyplata());
        System.out.print("\t\tPonadto mam premie: " + premia);
    }
    public void wypisz2()
    {
        super.wypisz();
        System.out.print("\t\tPonadto mam premie: " + premia);
    }
}
