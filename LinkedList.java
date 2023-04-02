package pointer.list.linked;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> cnt;

    public LinkedList() {
        head = cnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                cnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = cnt = new Node<E>(obj, ptr);
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj);
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = cnt = new Node<E>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = cnt = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head;
                Node<E> pre = head;

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                cnt = pre;
            }
        }
    }

    public void remove(Node p) {
        if (head != null) {
            if (p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) {
                        return;
                    }
                }
                ptr.next = p.next;
                cnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(cnt);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
        cnt = null;
    }

    public boolean next() {
        if (cnt == null || cnt.next == null) {
            return false;
        }
        cnt = cnt.next;
        return true;
    }

    public void printCurrentNode() {
        if (cnt == null) {
            System.out.println("선택한 노드가 없습니다");
        } else {
            System.out.println(cnt.data);
        }
    }

    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}