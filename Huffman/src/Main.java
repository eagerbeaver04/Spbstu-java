import Classes.Huffman.*;
import Classes.iostream.*;
import Classes.tree.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Use: java Huffman <encode/decode/info> <inputFile>");
            return;
        }

        String mode = args[0].toLowerCase();
        String inputFile = args[1];
        try {
            switch (mode) {
                case "encode" -> {
                    String text = FileReader.readFile(inputFile);
                    Tree tree = HuffmanBasic.buildHuffmanTree(text);
                    HashMap<Character, String> huffmanCode =  new HashMap<>();
                    HuffmanBasic.generateHuffmanCodes(tree, "", huffmanCode);
                    StringBuilder encodedString = new StringBuilder();
                    for (char c : text.toCharArray())
                    {
                        encodedString.append(huffmanCode.get(c));
                    }
                    String outputFilename = FileUtility.getOutputFileName(inputFile, "");
                    FileWriter.write(inputFile,outputFilename, huffmanCode, encodedString.toString());
                }
                case "decode" ->
                {
                    BitReader bitInputStream = new BitReader(new FileInputStream(inputFile));
                    String extension = FileReader.readExtensionFromFile(bitInputStream);
                    HashMap<Character, String> huffmanCode =FileReader.readHuffmanCode(bitInputStream);
                    String decodedString = FileReader.readEncodedStringFromFile(bitInputStream, huffmanCode);
                    String outputFilename = FileUtility.getOutputFileName(inputFile, extension);
                    FileWriter.writeDecoded(outputFilename, decodedString);
                }
                case "info" -> {
                    BitReader bitInputStream = new BitReader(new FileInputStream(inputFile));
                    FileReader.readExtensionFromFile(bitInputStream);
                    HashMap<Character, String> huffmanCode =  FileReader.readHuffmanCode(bitInputStream);
                    String decodedString = FileReader.readEncodedStringFromFile(bitInputStream, huffmanCode);
                    int originalSize = FileUtility.getOriginalSize(decodedString);
                    long compressedSize = FileUtility.getCompressedSize(inputFile);
                    double compressionRatio = (double) compressedSize / originalSize;
                    HuffmanBasic.printHuffmanCodes(huffmanCode);
                    System.out.println("Original size: " + originalSize + " bytes");
                    System.out.println("Compressed size: " + compressedSize + " bytes");
                    System.out.println("Compression ratio: " + compressionRatio * 100 + "%");
                }
                default -> System.out.println("Invalid mode. Use 'encode', 'decode', or 'info'.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}