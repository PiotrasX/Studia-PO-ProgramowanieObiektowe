package Lab8.Zad2;

public class Command
{
    public String ciagZnakow;

    public Command(String ciagZnakow) { this.ciagZnakow = ciagZnakow; }

    public void operation() { System.out.println(ciagZnakow); }
}
