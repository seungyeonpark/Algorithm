package stack;

import java.util.Scanner;

class IntStackTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStack stack = new IntStack(64);

        while (true) {
            System.out,printf("현재 데이터 수: %d/%d%n", stack.size(), stack.capacity());
            System.out.print("(1)push (2)pop (3)peek (4)dump (0)exit: ");

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
                    stack.push(x);
                } catch (IntStack.OverflowIntStackException e) {
                    System.out.println("스택이 가특 찼습니다");
                }
                break;

            case 2:
                try {
                    x = stack.pop();
                    System.out.printf("pop한 데이터는 : %d%n", x);
                } catch (IntStack.EmptyIntStackexception e) {
                    System.out.println("스택이 가득 찼습니다");
                }
                break;

            case 3:
                try {
                    x = stack.peek();
                    System.out.printf("peek한 데이터는 : %d%n", x);
                } catch () {
                    System.out.println("스택이 비었습니다");
                }
                break;

            case 4:
                s.dump();
                break;
            }
        }
    }
}