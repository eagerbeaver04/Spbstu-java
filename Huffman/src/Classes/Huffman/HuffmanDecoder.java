package Classes.Huffman;

import Classes.iostream.BitReader;
import Classes.iostream.FileReader;
import Classes.iostream.FileUtility;
import Classes.iostream.FileWriter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanDecoder
{
    private HashMap<Character, String> huffmanCode;
    private String decoded;

    private String outputFilename;

    private String extension;
    public HuffmanDecoder()
    {
        huffmanCode = new HashMap<>();
        decoded = "";
    }

    public void decodeFile(BitReader reader) throws IOException
    {
        huffmanCode = FileReader.readHuffmanCode(reader);
        decoded = FileReader.readEncodedStringFromFile(reader, huffmanCode);
    }

    public void decode(String inputFilename) throws IOException
    {
        BitReader reader = new BitReader(new FileInputStream(inputFilename));
        extension = FileReader.readExtensionFromFile(reader);
        decodeFile(reader);
        outputFilename = FileUtility.getOutputFileName(inputFilename, extension);
        FileWriter.writeDecoded(outputFilename, decoded);
    }

    public void printHuffmanCode()
    {
        HuffmanBasic.printHuffmanCodes(huffmanCode);
    }

    public String getOutputFilename()
    {
        return outputFilename;
    }
}
