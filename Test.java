import java.util.Scanner;

class Test {
    public static void main (String [] args) {

        //загаданное число. Оно будет генерироваться автоматически
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
        System.out.println("| Ведущий загадал число ''"+numb+"'' |");
        System.out.println(" ----------------------------- ");
        System.out.println(" ");

        //массив из 10 цифр. Сюда будут вноситься неудачные попытки
        int[] tries = new int[10];

        //вынесем угадываемое число и счётчик наружу
        int x=-1; //чтоб оно сходу не совпадало ни с чем
        int j=0; //счётчик циклов прохода while. Если совпадений в массиве нет, то попытка записывается в ячейку 10-j
        boolean inMass = false;

        //цикл будет продолжаться, пока угадает число
        while (x != numb) {

            //Попытка угадать число
            x=(int)(Math.random()*10+1);    /**
            System.out.println(" ");                //  Этот блок только для отображения
            System.out.println("--- "+x+" ---");    //  технической информации -
            System.out.println("---------");        //  какое число сгенерировал комп.
            System.out.println(" ");                //  В готовой программе его можно убрать
*/
            //нужно проверить совпадение с загаданным числом
            if (x != numb) { //НЕ угадали число
/**
                //Нарисуем наглядный массив
                System.out.println("Проверим, есть-ли "+x+" в массиве(Т)"); //
                System.out.print("{");                                      //  Техническая информация.
                for (int u=0; u<10; u++) {                                  //  Здесь будет отображаться
                    System.out.print(" |"+tries[u] + "| ");                  //  весь массив в формате
                }                                                           //  |0| |1| |2| |3| |...|
                System.out.println("}(Т)");                                 //  В готовой программе его можно убрать
                System.out.println(" ");                                    //
*/

                for (int i=0; i<10; i++) {
                    //System.out.println("Проверяем совпадение с числом "+mass[i]+"(Т)");   //  техническая информация

                    //внутри цикла проверяем, есть  такое число или нет
                    if (x == tries[i]) { //если есть совпадение, то заканчиваем цикл
                        //System.out.println("--- "+x+" совпадает с числом "+tries[i]+" ---(Т)");     //  техническая информация
                        //System.out.println("Число уже есть в массиве, придумай что-то новое(Т)");  //  техническая информация

                        //сигнализатор, что число есть в массиве
                        inMass = true;

                    } else { //если числа нет в массиве, то его надо добавить. Но не сразу, а когда проход закончен
                        //System.out.println("--- "+x+" НЕ совпадает с числом "+tries[i]+" ---");
                    }
                }


                //мы закончили проход по массиву. Число НЕ угадали. Нужно добавить его в массив.
                //Если числа не было в массиве, то добавляем в последнюю свободную позицию
                if ( inMass == false) {
                    //оглашаем число, раз уж его нет в массиве
                    System.out.println("Может это "+x+"?");

                        tries[(9-j)] = x;  //  добавляем число в ячейке последней свободной ячейке
                        System.out.println("Попытка неудачная, но ведь мы учимся на своих ошибках. Попробуй снова");
                } else {    // если число было в массиве, то его не добавляем, счётчик циклов след раз пойдёт с предыдущей позиции
                    j--;
                    //System.out.println("Это число уже было, попробуй другое(Т)");  //  техническая информация
                }
            } else {
                System.out.println("Может это "+x+"?");
                System.out.println("Угадал! Поздравляю!");
            }
         j++; //конец цикла, дальше будет цикл номер j+1
        }
    }
}
