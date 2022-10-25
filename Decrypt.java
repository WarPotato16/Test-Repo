import java.io.*;
import java.util.*;

public class Decrypt 
{
    public static void main(String args[]) throws IOException
    {
        File file2 = new File("password.dat");
        BufferedReader reader = new BufferedReader(new FileReader(file2));
        Scanner input = new Scanner(System.in);
        String filler = "";

        System.out.print("Enter your username: ");
        String username = input.nextLine();
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        filler = reader.readLine();
        boolean correct = false;

        while (filler != null)
        {
            String reveal = dec(filler);

            if (reveal.contains(username) && reveal.contains(password))
            {
                correct = true;
            }

            filler = reader.readLine();
        }

        if (correct)
        {
            System.out.print("You may enter the system!");
        }
        else
        {
            System.out.print("Intruder! System violation!");
        }

        reader.close();
        input.close();
    }

    public static String dec(String word)
    {
        String dWord = "";

        for (int i = 0; i <= word.length() - 1; i++)
        {
            char nChar = word.charAt(i);
            int ascii = (int)nChar;
            int nAscii = ascii + 17;
            char fChar = (char)nAscii;
            dWord += fChar;
        }

        return dWord;
    }
}