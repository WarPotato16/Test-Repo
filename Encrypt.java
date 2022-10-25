import java.io.*;

public class Encrypt
{
    public static void main(String[] args) throws IOException
    {
        String word = "";
        String comma = ",";
        
        try
        {
            File file = new File("2022Passwords.csv");
            File file2 = new File("password.dat");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
            word = reader.readLine();

            while (word != null)
            {
                String newWord = "";

                for (int i = 0; i <= word.length() - 1; i++)
                {
                    char nChar = word.charAt(i);
                    int ascii = (int)nChar;
                    int nAscii = ascii - 17;
                    char fChar = (char)nAscii;
                    newWord += fChar;
                }

                writer.write(newWord + comma);
                writer.newLine();
                word = reader.readLine();
            }
            writer.close();
            reader.close();
        }
        
        catch (IOException e)
        {
            System.err.println("Error with the file!");
            System.out.println("Check to see if the file exists!");
        }
    }
}