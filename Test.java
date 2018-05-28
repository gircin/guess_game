import java.util.Scanner;
class Test {
    public static void main(String[] args) {
        int numb;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число, которое будет отгадывать компьютер");
        do {
            numb = scanner.nextInt();
            System.out.println("Введи, пожалуйста, число от 1 до 10");
        }
        while (numb < 1 || numb > 10);

        System.out.println(" ");
        System.out.println(" ----------------------------- ");
        System.out.println("| Ведущий загадал число ''" + numb + "'' |");
        System.out.println(" ----------------------------- ");
        System.out.println(" ");

        boolean[] tries = new boolean[10];

        int x = 0;

        while (x != numb) {
            x = (int) (Math.random() * 10 + 1);

            if (x != numb) {

                if (tries[x - 1] == false) { 
                    System.out.println("Может это " + x + "?");
                    System.out.println("Попытка неудачная, но ведь мы учимся на своих ошибках. Попробуй снова");
                    System.out.println(" ");
                    tries[(x - 1)] = true;  
                }
            }
        }
        System.out.println(" ");
        System.out.println("Может это " + x + "???");
        System.out.println("Угадал! Поздравляю!");
    }
}
