package Lab8.Zad3;

import java.util.*;

public class Stos
{
    private List<String> stos;

    public Stos() { this.stos = new ArrayList<>(); }

    public void push(String text) { stos.add(text); }

    public String peek() { return stos.get(stos.size() - 1); }

    public String pop()
    {
        String text = stos.get(stos.size() - 1);
        stos.remove(stos.size() - 1);
        return text;
    }

    public boolean empty()
    {
        try
        {
            stos.get(0);
            return false;
        }
        catch (IndexOutOfBoundsException e)
        {
            return true;
        }
    }

    public String toString()
    {
        List<String> sort = new ArrayList<>(stos);
        Collections.reverse(sort);
        return sort.toString();
    }
}
