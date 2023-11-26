package Classes.Huffman;

import Classes.tree.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanBasic
{
    public static void generateHuffmanCodes(Tree tree, String str, HashMap<Character, String> huffmanCode)
    {
        tree.generateHuffmanCodes(str,huffmanCode);
    }
    public static Tree buildHuffmanTree(String text)
    {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getFrequency));

        freq.forEach((key, value) -> pq.add(new Node(key, value)));
        while (pq.size() != 1)
        {
            Node current = new Node('\0', 0, pq.poll(), pq.poll());
            pq.add(current.setSum());
        }
        return new Tree(pq.peek());
    }

    public static void printHuffmanCodes(HashMap<Character, String> huffmanCode)
    {
        System.out.println("Huffman Tree:");
        huffmanCode.forEach((key, value) -> {
            if (key == '\n')
                System.out.println("\\n " + value);
            else
                System.out.println(key + " " + value);
        });
    }
}