package Classes.Huffman;

import Classes.iostream.FileUtility;

import java.io.IOException;

public class HuffmanInfo
{
    private HuffmanDecoder info;

    String inputFilename;
    String outputFilename;
    private long inputSize;
    private long outputSize;
    private double compressionRatio;

    public HuffmanInfo()
    {
        inputFilename = "";
        outputFilename = "";
        info = new HuffmanDecoder();
        inputSize=0;
        outputSize=0;
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
        inputSize = FileUtility.getFileSizeNIO(inputFilename);
        outputSize = FileUtility.getFileSizeNIO(outputFilename);
        compressionRatio = (double) inputSize / outputSize;
    }

    public void getInfo(String filename) throws IOException
    {
        decode(filename);
        getSizes();
    }
    public void printInfo()
    {
        info.printHuffmanCode();
        System.out.println("Original size: " + inputSize + " bytes");
        System.out.println("Compressed size: " + outputSize + " bytes");
        System.out.println("Compression ratio: " + compressionRatio * 100 + "%");
    }
}
