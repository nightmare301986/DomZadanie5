/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
2) Вывод всего
Пример:
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 1242353
К: Введите 1) Добавление номера
2) Вывод всего
Я ввожу: 1
К: Введите фамилию
Я: Иванов
К: Введите номер
Я: 547568
К: Введите 1) Добавление номера
2) Вывод всего
Я: 2
Иванов: 1242353, 547568 */

//При проверке (запуске) программы писал фамилии транслитом - проблема с кириллицей в VS Code

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Spravochnik {
    public static void main(String[] args) throws Exception {

        boolean stop = false;
        String line = "";
        String line1 = "";
        Integer line2 = 0;

        Map<String, ArrayList<Integer>> db = new HashMap<>();

        while (!stop) {                                            //Реализация "повторяющегося" меню
            Scanner in = new Scanner(System.in);
            System.out.println("Для остановки программы введите слово 'stop'");
            System.out.println("Для заполнения справочника введите '1'");
            System.out.println("Для просмотра справочника введите '2'");
            line = in.nextLine();

            if (line.equals("1")) {
                System.out.println("Введите фамилию ");
                line1 = in.nextLine();
                System.out.println("Введите номер телефона ");
                line2 = in.nextInt();
                addNumb(line1, line2, db);
            }
            if (line.equals("2")) {
                showBook(db);
            }
            if (line.equals("stop")) {
                stop = true;
                in.close();
            }
        }
    }
                                            //Добавление номера телефона
    public static void addNumb(String key, int value, Map<String, ArrayList<Integer>> map_n) {
        if (map_n.containsKey(key)) {
            map_n.get(key).add(value);
        } else {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(value);
            map_n.put(key, list1);
        }

    }
                                            //Вывод содержимого справочника
    public static void showBook(Map<String, ArrayList<Integer>> map_n) {
        for (var item : map_n.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + "; ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
}