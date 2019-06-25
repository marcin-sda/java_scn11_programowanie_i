package com.sda;

import com.sda.structures.list.ListImpl;
import com.sda.structures.queue.QueueIntImpl;
import com.sda.structures.stack.StackImpl;

public class Main {

    // Tutaj testujemy swoją wersję listy.
    public static void testList() {
        ListImpl lista = new ListImpl();
        lista.append(10);
        lista.append(20);
        lista.append(30);
        lista.prepend(5);
        lista.insert(222, 0);
        lista.print();
        lista.remove(4);
        System.out.println("\n");
        lista.print();       lista.set(555, 2);
        System.out.println("\n");
        lista.print();
        int position = 10;
        Integer intAtPosition = lista.get(position);
        if (intAtPosition != null) {
            System.out.println("\nNode value at position " +
                    position + " is: " +
                    intAtPosition.toString());
        } else {
            System.out.println("No node at position "
            + position + "!!!");
        }
    }

    public static void testStack() {
        StackImpl<String> stack = new StackImpl(10);
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("capacity: " + stack.getCapacity());
        stack.push("abc");
        stack.push("def");
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("peek: " + stack.peek());
    }

    public static void testQueue() {
        QueueIntImpl queueInt = new QueueIntImpl(10);
        for (int i = 0; i < 10; i++) {
            queueInt.enqueue(i);
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("<< ");
        for (int i = 0; i < 9; i++) {
            buffer.append(", " + queueInt.peek());
            queueInt.dequeue();
        }

        System.out.println("Dequeued following values: " + buffer.toString());

        queueInt.enqueue(5);
        queueInt.enqueue(100);
        queueInt.enqueue(200);
        queueInt.enqueue(300);
        queueInt.dequeue();
        queueInt.enqueue(500);
        queueInt.dequeue();
    }

    public static void testBST() {
        //BinaryTree<Integer> bst = new BinaryTreeImpl<>();
        //bst.add(33);
        //bst.add(10);
        //bst.add(5);
        //bst.add(44);
        //bst.add(15);
        //bst.add(22);
        //boolean found = bst.find(33);
        //bst.traverse(BinaryTree.TraversalMode.BFS);
    }


    public static void main(String[] args) {
    }
}
