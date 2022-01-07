package queue;

import java.util.Scanner;

class IntQueueTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntQueue queue = new IntQueue(64);

        while (true) {
            System.out,printf("현재 데이터 수: %d/%d%n", stack.size(), stack.capacity());
            System.out.print("(1)enque (2)deque (3)peek (4)dump (0)exit: ");

            int menu = scanner.nextInt();
            if (menu == 0) {
                break;
            }

            int x;
            switch (menu) {
            case 1:
                System.out.print("data input >> ");
                x = scanner.nextInt();
                try {
                    s.enque(x);
                } catch (IntQueue.OverflowIntStackException e) {
                    System.out.println("큐가 가득 찼습니다.");
                }
                break;

            case 2:
                try {
                    x = s.deque();
                    System.out.printf("deque한 데이터는 : %d%n", x);
                } catch (IntQueue.EmptyIntQueueException e) {
                    System.out.println("큐가 비어 있습니다.");
                }
                break;

            case 3:
                try {
                    x = s.peek();
                    System.out.printf("peek한 데이터는 : %d%n", x);
                } catch (IntQueue.EmptyIntQueueException e) {
                    System.out.println("큐가 비어 있습니다.");
                }
                break;

            case 4:
                s.dump();
                break;
            }
        }
    }
}