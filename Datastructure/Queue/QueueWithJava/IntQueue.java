package stack;

public class IntQueue {
    private int max;
    private int front;
    private int back;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntQueue(int capacity) {
        num = front = back = 0;
        max = capacity;

        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntStackException {
        if (num >= max) {
            throw new OverflowIntStackException();
        }

        que[back] = x;
        back = (back + 1) % max;
        num++;

        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        int x = que[front];
        front = (front + 1) % num;
        num--;

        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        return que[front];
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x) {
                return idx;
            }
        }

        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
            return;
        }

        for (int i = 0; i < num; i++) {
            System.out.printf("%d ", que[(i + front) % max]);
        }
    }
}