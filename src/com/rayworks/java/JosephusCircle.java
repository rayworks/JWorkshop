package com.rayworks.java;

/**
 * Created by Shirley on 9/12/15.
 */
public class JosephusCircle {
    public static class Node {
        public int value;
        public Node next;
    }

    public static Node buildCircle(int m) {
        Node header = null;
        Node currNode, preNode;
        currNode = preNode = null;

        for (int i = 1; i <= m; i++) {
            Node node = new Node();
            node.value = i;
            if (i == 1) {
                header = node;
            }
            if (preNode != null) {
                preNode.next = node;
            }
            preNode = node;

            // sealed the circle
            if (i == m) {
                node.next = header;
            }
        }

        /*Node pt = header;
        while (pt != null){
            System.out.print(pt.value + " , ");
            pt = pt.next;
        }*/

        return header;
    }

    public static void main(String[] args) {
        // setup m linklist
        // set number n

        // remove node holds value n
        Node header = buildCircle(7);
        int num = 3;

        Node pt = header;
        Node prePt;
        while (pt.next != pt) {
            int i = 1;
            prePt = pt;
            while (i < num) {
                prePt = pt;
                pt = pt.next;
                ++i;
            }

            System.out.println(pt.value);

            // remove the current dequeued node
            Node newPt = pt.next;
            prePt.next = newPt;

            // reset the pivator
            pt = newPt;
        }

        System.out.println(pt.value);
        System.out.println("All people dequeued");
    }
}
