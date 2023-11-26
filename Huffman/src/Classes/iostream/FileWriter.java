package Classes.iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class FileWriter {

    public static void write(String inputFilename,String outputFilename, Map<Character, String> huffmanCode, String data) throws IOException
    {
        try (BitWriter bitOutputStream = new BitWriter(new FileOutputStream(outputFilename)))
        {
            String extension = FileUtility.getFileExtension(inputFilename);
            for (int i = 0; i < extension.length(); i++)
            {
                char extensionChar = extension.charAt(i);
                bitOutputStream.writeBits(extensionChar, 8);
            }
            bitOutputStream.writeBits(0, 8);

            for (Map.Entry<Character, String> entry : huffmanCode.entrySet())
            {
                char symbol = entry.getKey();
                String code = entry.getValue();
                bitOutputStream.writeBits(symbol, 8);
                bitOutputStream.writeBits(code.length(), 32);
                for (char bit : code.toCharArray())
                    bitOutputStream.writeBit(bit == '1');
            }
            bitOutputStream.writeBits(0, 8);
            for (char c : data.toCharArray())
                bitOutputStream.writeBit(c == '1');
        }
    }

   public static void writeDecoded(String outputFilename, String decoded) throws IOException
   {
        try (BitWriter bitOutputStream = new BitWriter(new FileOutputStream(outputFilename))) {
            byte[] dataBytes = decoded.getBytes();
            for (byte dataByte : dataBytes)
            {
                for (int i = 7; i >= 0; i--)
                    bitOutputStream.writeBit((dataByte >> i & 1) == 1);
            }
        }
    }
}