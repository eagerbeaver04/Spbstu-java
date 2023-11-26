package Classes.tree;

import java.util.HashMap;

public class Node {
    private char symbol;
    private int frequency;
    private Node left = null;
    private Node right = null;

    public Node(char symbol_, int freq_)
    {
        symbol = symbol_;
        frequency = freq_;
    }

    public Node setSum()
    {
        if(left!=null)
            frequency+= left.frequency;
        if(right!=null)
            frequency+= right.frequency;
        return this;
    }
    public int getFrequency()
    {
        return frequency;
    }

    public Node(char symbol_, int freq_, Node left_, Node right_) {
        symbol = symbol_;
        frequency = freq_;
        left = left_;
        right = right_;
    }
    public void generateHuffmanCodes(String str, HashMap<Character, String> huffmanCode) {

        if (left == null && right == null)
        {
            huffmanCode.put(symbol, str);
            return;
        }
        if(left!=null)
            left.generateHuffmanCodes( str + "0", huffmanCode);
        if(right!=null)
            right.generateHuffmanCodes(str + "1", huffmanCode);
    }
}