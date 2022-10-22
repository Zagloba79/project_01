import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker tracker = new StepTracker();

        while (userInput != 0) {
            if (userInput == 1) { // Ввести количество шагов за определённый день
                System.out.println("Введите номер месяца от 0 до 11.");
                int chosenMonth = scanner.nextInt();
                tracker.checkMonth(chosenMonth);
                System.out.println("Введите число от 1 до 30.");
                int number = scanner.nextInt();
                tracker.checkNumber(number);
                System.out.println("Введите количество пройденных шагов за этот день.");
                int stepsPerDay = scanner.nextInt();
                tracker.checkSteps(stepsPerDay);
                tracker.changesSteps(chosenMonth, number, stepsPerDay);
            } else if (userInput == 2) {
                System.out.println("За какой месяц вас интересует статистика?");
                System.out.println("Введите номер месяца от 0 до 11.");
                int chosenMonth = scanner.nextInt();
                tracker.checkMonth(chosenMonth);
                tracker.printStatistic(chosenMonth);
            } else if (userInput == 3) { // Изменить цель по количеству шагов в день
                System.out.println("Введите новую цель по количеству шагов в день.");
                int newStepGoal = scanner.nextInt();
                tracker.checkSteps(newStepGoal);
                tracker.changeStepGoal(newStepGoal);
            } else {
                System.out.println("Извините, нет такой команды.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}