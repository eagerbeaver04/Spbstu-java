package Classes.tree;

import java.util.HashMap;

public class Tree
{
    private Node root;
    public Tree()
    {
        root = null;
    }
    public Tree(Node root_)
    {
        root = root_;
    }
    public void generateHuffmanCodes(String str, HashMap<Character, String> huffmanCode)
    {
        root.generateHuffmanCodes(str, huffmanCode);
    }


}
