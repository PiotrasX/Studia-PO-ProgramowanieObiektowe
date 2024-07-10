package Lab2.Zad2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Zadanie2
{
    private static final Map<String, List<String>> dane = new LinkedHashMap<>();
    public static Map<String, List<String>> getDane() { return dane; }
    public static void setDane(String nazwa, List<String> resztaDanych) { dane.put(nazwa, resztaDanych); }

    public static void main(String[] args)
    {
        Logowanie logowanieGUI = new Logowanie();
        logowanieGUI.setVisible(true);
        setDane("admin", Arrays.asList("admin", "admin@admin.admin", "6000","Java;Python;"));
        setDane("PiotrasX", Arrays.asList("123Piotr#", "piotr@gmail.com", "5000","C#"));
        setDane("Monika1337", Arrays.asList("MoniMoni1!", "monika@gmail.com", "7000",""));
        setDane("Mietek3000", Arrays.asList("sereczek@1AS", "mieczyslaw@gmail.com", "6500",""));
    }
}
