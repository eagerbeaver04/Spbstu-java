package Classes.Huffman;

import Classes.iostream.FileUtility;

import java.io.IOException;

public class HuffmanInfo
{
    private HuffmanDecoder info;

    String inputFilename;
    String outputFilename;
    private long encodedSize;
    private long decodedSize;
    private double compressionRatio;

    public HuffmanInfo()
    {
        inputFilename = "";
        outputFilename = "";
        info = new HuffmanDecoder();
        encodedSize=0;
        decodedSize=0;
        compressionRatio=0;
    }

    private void decode(String filename) throws IOException
    {
        inputFilename =filename;
        info.decode(inputFilename);
        outputFilename = info.getOutputFilename();
    }

    private void getSizes() throws IOException
    {
        encodedSize = FileUtility.getFileSizeNIO(inputFilename);
        decodedSize = FileUtility.getFileSizeNIO(outputFilename);
        compressionRatio = (double) decodedSize / encodedSize;
    }

    public void getInfo(String filename) throws IOException
    {
        decode(filename);
        getSizes();
    }
    public void printInfo()
    {
        info.printHuffmanCode();
        System.out.println("Original size: " + decodedSize + " bytes");
        System.out.println("Compressed size: " + encodedSize + " bytes");
        System.out.println("Compression ratio: " + compressionRatio * 100 + "%");
    }
}
