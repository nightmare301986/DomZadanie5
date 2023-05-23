import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности Имени.
 */
public class SpisokSotrPoisk {
    public static void main(String[] args) {
        Map<String, Integer> namePeople = new HashMap<>();
        String[] people1 = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        countName(people1, namePeople);
        sortedStaff(namePeople);

    }

    // Функция, считающая кол-во повторений имен сотрудников
    public static void countName(String[] people, Map<String, Integer> namePeople) {
        for (String person : people) {
            String name = person.split(" ")[0];
            if (namePeople.containsKey(name)) {
                namePeople.put(name, namePeople.get(name) + 1);
            } else {
                namePeople.put(name, 1);
            }
        }
    }

    // Функция сортировки по убыванию популярности имени
    public static void sortedStaff(Map<String, Integer> namePeople) {
        Map<String, Integer> sortedName = namePeople.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))    // Использование лямбда-выражения (нашел такое использование)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));

        sortedName.entrySet().forEach(System.out::println); 
    }
}