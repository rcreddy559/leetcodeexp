package com.pros;

public class MyLinkedList {
    private Node head;

    MyLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        Node newHead = new Node(data);
        if (head == null) {
            head = newHead;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newHead);
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void datete(int data) {
        if (head == null)
            return;

        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null && current.getData() != data) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("end");
    }

    public int count() {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.append(10);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.print();
        System.out.println("Size: " + linkedList.count());
        System.out.println("delte 20");
        linkedList.datete(20);
        linkedList.print();
        System.out.println("Size: " + linkedList.count());
    }
}

class Node {
    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

}