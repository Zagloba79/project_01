import java.util.Scanner;

public class StepTracker { //объявили общий класс

    MonthData[] monthToData; //поле конструктора

    StepTracker () {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    static class MonthData {
        int[] month = new int[30];
    }
    int stepGoal = 10000; // цель шагов за день
    Converter convert = new Converter();


    void changesSteps(int chosenMonth, int number, int stepsPerDay) { // Ввести количество шагов за определённый день
        number = number - 1;
        monthToData[chosenMonth].month[number] = stepsPerDay;
    }

    void changeStepGoal(int newStepGoal) { // Изменить цель по количеству шагов в день
        stepGoal = newStepGoal;
    }

    void printStatistic(int chosenMonth) { // Напечатать статистику за определённый месяц
        stepsInMonth(chosenMonth); //вывод количества шагов за месяц
        countSum(chosenMonth); //вывод общего количества шагов за месяц
        maxDay(chosenMonth); //вывод максимального количества шагов за день
        midDay(chosenMonth); //вывод среднего количества шагов за месяц
        distance(chosenMonth); //пройденная дистанция
        burnedCalories(chosenMonth); //сожженные калории
        bestSet(chosenMonth); //лучшая серия кол-ва дней подряд больше нормы шагов
    }


    void stepsInMonth(int chosenMonth) { //вывод количества шагов за месяц
        for (int i = 0; i < 30; i++) {
            System.out.print((i + 1) + " день: " + monthToData[chosenMonth].month[i] + ", ");
        }
        System.out.println();
    }
    void countSum(int chosenMonth) { //вывод общего количества шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + monthToData[chosenMonth].month[i];
        }
        System.out.println("Общее пройденное количество шагов за месяц: " + sumSteps);
    }
    void maxDay(int chosenMonth) { //вывод максимального количества шагов за день
        int maxSteps = monthToData[chosenMonth].month[0];
        for (int i = 1; i < 30; i++) {
            if (maxSteps < monthToData[chosenMonth].month[i]) {
                maxSteps = monthToData[chosenMonth].month[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов за день: " + maxSteps);
    }
    void midDay(int chosenMonth) { //вывод среднего количества шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + monthToData[chosenMonth].month[i];
        }
        System.out.println("Среднее пройденное количество шагов за день: " + (sumSteps / 30));
    }
    void distance(int chosenMonth) { //пройденная дистанция
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + monthToData[chosenMonth].month[i];
        }
        convert.toKilometers(sumSteps);
    }
    void burnedCalories(int chosenMonth) { //сожженные калории
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + monthToData[chosenMonth].month[i];
        }
        convert.toCalories(sumSteps);
    }
    void bestSet(int chosenMonth) { //лучшая серия кол-ва дней подряд больше нормы шагов
        int maxSet = 0;
        int set = 0;
        for (int i = 0; i < 30; i++) {
            if (monthToData[chosenMonth].month[i] >= stepGoal) {
                set++;
            } else {
                if (set > maxSet) {
                    maxSet = set;
                    set = 0;
                } else {
                    set = 0;
                }
            }
        }
        System.out.println("Максимальное количество подряд идущих дней - " + maxSet);
    }
    int checkMonth(int month) {
        Scanner scanner = new Scanner(System.in);
        while (month < 0 || month > 11) {
            System.out.println("Вы ввели неверный номер месяца.");
            System.out.println("Введите номер месяца от 0 до 11.");
            month = scanner.nextInt();
        }
        return month;
    }
    int checkNumber(int number) {
        Scanner scanner = new Scanner(System.in);
        while (number < 1 || number > 30) {
            System.out.println("Вы ввели неверное число.");
            System.out.println("Введите число от 1 до 30.");
            number = scanner.nextInt();
        }
        return number;
    }
    int checkSteps(int steps) {
        Scanner scanner = new Scanner(System.in);
        while (steps < 0) {
            System.out.println("Вы ввели отрицательное число.");
            System.out.println("Введите количество шагов еще раз.");
            steps = scanner.nextInt();
        }
        return steps;
    }
}