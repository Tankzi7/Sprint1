import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    int step = 0, personX, personY, x = 0, y = 0, personLive = 3, sizeBoard = 5;
    personX = 1 + sizeBoard / 2;
    personY = 1 + sizeBoard / 2;
    step = step + 1;
    String castle = "\uD83C\uDFF0";
    int castleY = 1;
    String[][] b0ard = new String[sizeBoard][sizeBoard];
    for (int row = 0; row < sizeBoard; row++) {
    for (int col = 0; col < sizeBoard; col++) {
        board[row][col] = "  ";
    }
}
        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        Monster[] monsters = new Monster[countMonster];
        int count = 0;

        Random randoM = new Random();
        while (count < countMonster) {
            Monster monster;

            if (randoM.nextBoolean()) {
                monster = new Monster(sizeBoard);
            } else monster = new Bigmonster(sizeBoard);

            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (b0ard[row][column].equals("  ")) {
                b0ard[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
            }
        }
        Random rand0m = new Random();
        int castleX = 1 + rand0m.nextInt(sizeBoard);
        int counterY = 1;
        for (y = 1; y <= sizeBoard; y++) {
            String answer = null;
            for (x = 1; x <= sizeBoard; x++) {
                            board[y][x] = " ";
                        }
                    }
                    for (String[] r0w : new String[][]{b0ard}) {
                        for (String col : r0w) {
                        }
                    }
                    board[(castleY - 1) * sizeBoard + castleX - 1] = castle;
                    String person = "Гг";
                    board[(personY - 1) * sizeBoard + personX - 1] = person;
                    Monster monster;
                    System.out.println("Привет! Ты готов начать играть? (Напиши: ДА или НЕТ)");
                    System.out.println("Количество жизней: " + personLive + " " + person);
                    Scanner scanner = new Scanner(System.in);
                    answer = scanner.nextLine();
                    switch (answer) {
                        case "ДА": {

                            System.out.println("Начинаем играть");
                            System.out.println("Выбери сложность игры (от 1 до 5):");
                            int difficultGame = scanner.nextInt();
                            System.out.println("Выбранная сложность:\t" + difficultGame);
                            while ((personLive > 0) && !(castleX == personX && castleY == personY)) {

                                System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
                                System.out.println("Координаты персонажа - (x: " + personX + ", y: " + personY + ")");
                                board[(personY - 1) * sizeBoard + personX - 1] = "  ";
                                board[(personY - 1) * sizeBoard + personX - 1] = person;
                                x = scanner.nextInt();
                                y = scanner.nextInt();
                                {
                                    if (b0ard[y - 1][x - 1].equals("  ")) {
                                        b0ard[personY - 1][personX - 1] = "  ";
                                        personX = x;
                                        personY = y;
                                        step++;

                                        System.out.println("Ход корректный; новые координаты: "
                                                + personX + ", " + personY
                                                + "\nХод номер: " + step);
                                    } else if (b0ard[y - 1][x - 1].equals(castle)) {
                                        System.out.println("Вы прошли игру!");
                                        break;
                                    } else {
                                        for (Monster Monster : monsters) {
                                            if (monster.conflictPerson(x, y)) {
                                                if (monster.taskMonster(difficultGame)) {
                                                    b0ard[personY - 1][personX - 1] = "  ";
                                                    personX = x;
                                                    personY = y;
                                                    step++;
                                                } else {
                                                    personLive--;
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    System.out.println("Некорректный ход");
                                }
                                if (b0ard[(personY - 1) * sizeBoard + personX - 1].equals(castle)) {
                                    System.out.println("Вы прошли игру");
                                    System.out.println("Количество жизней:\t" + personLive + "\n");
                                } else {
                                    boolean taskMonster;
                                    {
                                        int a = rand0m.nextInt(200 * difficultGame);
                                        int b = rand0m.nextInt(200 * difficultGame);
                                        int trueAnswer = a + b;
                                        System.out.println("Реши пример: " + a + " + " + b + " = ?");
                                        int ans = scanner.nextInt();
                                        if (trueAnswer == ans) {
                                            System.out.println("Верно! Ты победил монстра");
                                            boolean success = taskMonster();
                                            if (success) {
                                                b0ard[personY - 1][personX - 1] = "  ";
                                                personX = x;
                                                personY = y;
                                                step++;

                                            } else {
                                                System.out.println("Ты проиграл эту битву!");
                                                personLive--;
                                                if (personLive <= 0) {
                                                    a = rand0m.nextInt(1000);
                                                    b = rand0m.nextInt(1000);
                                                    trueAnswer = a + b;
                                                    System.out.println("Реши пример: " + a + " + " + b + " = ?");
                                                    ans = scanner.nextInt();
                                                    if (trueAnswer == ans) {
                                                        System.out.println("Верно! Ты победил монстра");
                                                        personLive++;
                                                    } else {
                                                        System.out.println("Ты сдох!");
                                                        personLive--;
                                                    }
                                                    if (personLive < 0) {
                                                        break;
                                                    }
                                                }
                                                System.out.println("Решите задачу.");
                                                {
                                                    Random random1 = new Random();
                                                    a = rand0m.nextInt(1000);
                                                    b = rand0m.nextInt(1000);
                                                    trueAnswer = a + b;
                                                    System.out.println("Реши пример: " + a + " + " + b + " = ?");
                                                    Scanner scanner1 = new Scanner(System.in);
                                                    ans = scanner.nextInt();
                                                    if (trueAnswer == ans) {
                                                        System.out.println("Верно! Ты победил монстра");
                                                        return;
                                                    } else {
                                                        System.out.println("Ты проиграл эту битву!");
                                                    }


                                                }
                                            }
                                        }
                                    }

                                }
                                break;
                            }
                        }
                    }
                }
                break;
                throw new IllegalStateException("Unexpected value: " + answer);
            }
            throw new IllegalStateException("Unexpected value: " + answer);
        }}}
    

    private static boolean taskMonster() {
        return false;
    }
    static void outputBoard(String[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] row : b0ard) {
            System.out.println(wall);
            for (String col : row) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);

        System.out.println("Количество жизней:\t" + live + "\n");
    } 
