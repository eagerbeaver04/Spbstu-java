package Classes.Huffman;

import Classes.iostream.FileReader;
import Classes.iostream.FileUtility;
import Classes.iostream.FileWriter;
import Classes.tree.Tree;

import java.io.IOException;
import java.util.HashMap;

public class HuffmanEncoder
{
    Tree tree;
    String input;
    HashMap<Character, String> huffmanCode;
    StringBuilder encoded;
    public HuffmanEncoder()
    {
        tree = new Tree();
        input = "";
        huffmanCode  =new HashMap<>();
        encoded = new StringBuilder();
    }

    private void encodeString(String content)
    {
        input = content;
        tree = HuffmanBasic.buildHuffmanTree(content);
        HuffmanBasic.generateHuffmanCodes(tree, "", huffmanCode);
        for (char c : content.toCharArray())
            encoded.append(huffmanCode.get(c));
    }

    public void encode(String inputFilename) throws IOException
    {
        encodeString(FileReader.readFile(inputFilename));
        String outputFilename = FileUtility.getOutputFileName(inputFilename, "");
        FileWriter.write(inputFilename,outputFilename, huffmanCode, encoded.toString());
    }
}
