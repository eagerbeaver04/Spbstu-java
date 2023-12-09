package Classes.iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class FileWriter
{

    public static void write(String inputFilename,String outputFilename, Map<Character, String> huffmanCode, String data) throws IOException
    {
        try (BitWriter Output = new BitWriter(new FileOutputStream(outputFilename)))
        {
            int lastDotIndex = inputFilename.lastIndexOf('.');
            String extension="";
            if (lastDotIndex != -1)
                extension = inputFilename.substring(lastDotIndex + 1);
            for (int i = 0; i < extension.length(); i++)
            {
                char extensionChar = extension.charAt(i);
                Output.writeBits(extensionChar, 8);
            }
            Output.writeBits(0, 8);

            for (Map.Entry<Character, String> entry : huffmanCode.entrySet())
            {
                char symbol = entry.getKey();
                String code = entry.getValue();
                Output.writeBits(symbol, 8);
                Output.writeBits(code.length(), 32);
                for (char bit : code.toCharArray())
                    Output.writeBit(bit == '1');
            }
            Output.writeBits(0, 8);
            for (char c : data.toCharArray())
                Output.writeBit(c == '1');
        }
    }

    public static void writeDecoded(String outputFilename, String decoded) throws IOException
    {
        try (BitWriter Output = new BitWriter(new FileOutputStream(outputFilename))) {
            byte[] dataBytes = decoded.getBytes();
            for (byte dataByte : dataBytes)
            {
                for (int i = 7; i >= 0; i--)
                    Output.writeBit((dataByte >> i & 1) == 1);
            }
        }
    }
}