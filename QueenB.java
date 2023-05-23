/*На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8 */

/*Строго математически задачу можно сформулировать несколькими способами, например, так: «Заполнить матрицу размером 
8×8 нулями и единицами таким образом, чтобы сумма всех элементов матрицы была равна 8, 
при этом сумма элементов ни в одном столбце, строке или диагональном ряде матрицы не превышала единицы». */

public class QueenB {
    private int[] column; // Наличие ферзя в одном и том же столбце, если равно 1, то случилась такая позиция (расстановка)
    private int[] queenURLB; // Есть ли ферзь сверху справа и пошли налево вниз
    private int[] queenRULB; // Есть ферзь сверху слева и пошли направо вниз
    private int[] queen; // Ответ (верная расстановка ферзей)
    private int num; // Номер решения

    public QueenB() {
        column = new int[8 + 1];
        queenURLB = new int[(2 * 8) + 1];
        queenRULB = new int[(2 * 8) + 1];
        for (int i = 1; i <= 8; i++)
            column[i] = 0;
        for (int i = 1; i <= (2 * 8); i++)
            queenURLB[i] = queenRULB[i] = 0;                       // Исходная позиция (без ферзя)
        queen = new int[8 + 1];
    }

    public void checkQn(int i) {
        if (i > 8) {
            showAnswer();
        } else {
            for (int j = 1; j <= 8; j++) {
                if ((column[j] == 0) && (queenURLB[i + j] == 0) && (queenRULB[i - j + 8] == 0)) {   // Если ферзей нет
                    queen[i] = j;                                                                   // Установить как занятый
                    column[j] = 1;
                    queenURLB[i + j] = 1;
                    queenRULB[i - j + 8] = 1;
                    checkQn(i + 1);                                                                 // Вызов цикла (рекурсия)
                    column[j] = 0;
                    queenURLB[i + j] = 0;
                    queenRULB[i - j + 8] = 0;
                }
            }
        }
    }

    protected void showAnswer() {                       // Вывод доски с правильной расстановкой                                                
        num++;
        System.out.println(" \n Ответ" + num);
        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                if (queen[y] == x) {
                    System.out.print("+");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueenB queen = new QueenB();
        queen.checkQn(1);
    }
}
