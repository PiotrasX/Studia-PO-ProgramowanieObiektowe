package Lab9.ZadaniaLekcja;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        TextFile textFile = new TextFile();
        BinaryFile binaryFile = new BinaryFile();

        textFile.SaveFile();
        textFile.ReadFile();

        textFile.SaveFileWriter();
        System.out.println(textFile.ReadBufferFile());

        binaryFile.SaveBinary();
        System.out.println(binaryFile.ReadBinray());
    }
}
