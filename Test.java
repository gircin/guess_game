import java.util.Scanner;

class Test {
    public static void main(String[] args) {

        //загаданное число. Оно вводится в консоль
        int numb;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число, которое будет отгадывать компьютер");
        do {
            numb = scanner.nextInt();
            System.out.println("Введи, пожалуйста, число от 1 до 10");
        }
        while (numb < 1 || numb > 10);

        //для красоты выделяем загаданное Ведущим число
        System.out.println(" ");
        System.out.println(" ----------------------------- ");
        System.out.println("| Ведущий загадал число ''" + numb + "'' |");
        System.out.println(" ----------------------------- ");
        System.out.println(" ");

        //булевый массив из 10 переменных false. Если будет встречаться число,
        //соответствующее порядковому номеру переменной,
        //то переменная становится true
        boolean[] tries = new boolean[10];

        //вынесем угадываемое число и счётчик наружу
        int x = 0;

        //цикл будет продолжаться, пока угадает число
        while (x != numb) {
            //Попытка угадать число
            x = (int) (Math.random() * 10 + 1);

            //нужно проверить совпадение с загаданным числом
            if (x != numb) { // не угадал

                if (tries[x - 1] == false) { //это число НЕ вносилось в массив
                    System.out.println("Может это " + x + "?");
                    System.out.println("Попытка неудачная, но ведь мы учимся на своих ошибках. Попробуй снова");
                    System.out.println(" ");
                    tries[(x - 1)] = true;  // переключаем ячейку, запоминаем, что это число уже было
                }
            }
        }
        System.out.println(" ");
        System.out.println("Может это " + x + "???");
        System.out.println("Угадал! Поздравляю!"); // КОНЕЦ
    }
}
