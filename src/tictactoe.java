import java.util.Scanner;

public class karalama {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int printCount = 0;
        Scanner scanner = new Scanner(System.in);
        char[][] multiArr = new char[3][3];
        boolean xPrinted = false;
        boolean end;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                multiArr[i][j] = ' ';
            }
        }

        printTable(multiArr);

        int firstNum = 0;
        int secondNum = 0;
        String first;
        String second;
        while (true) {

            first = scanner.next();
            second = scanner.next();
            try {
                firstNum = Integer.parseInt(first);
                secondNum = Integer.parseInt(second);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if ((firstNum > 3 || firstNum < 1) || (secondNum > 3 || secondNum < 1)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (multiArr[firstNum - 1][secondNum - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            } else {
                if (xPrinted) {
                    multiArr[firstNum - 1][secondNum - 1] = 'O';
                    xPrinted = false;
                } else {
                    multiArr[firstNum - 1][secondNum - 1] = 'X';
                    xPrinted = true;
                }
                printCount++;
                printTable(multiArr);
                if (printCount > 4) {
                    end = isThereAWinner(multiArr, printCount);
                    if (end) {
                        break;
                    }
                }
            }

        }

    }

    public static void printTable(char[][] arr) {
        int i;
        int j = 0;
        for (i = -1; i < 4; i++) {
            if (i == -1 || i == 3) {
                System.out.println("---------");
            } else {
                System.out.print("| ");
                System.out.printf("%c %c %c", arr[i][j], arr[i][j + 1], arr[i][j + 2]);
                System.out.println(" |");
            }
        }
    }

    public static boolean isThereAWinner(char[][] multiArr, int count) {
        boolean end = false;
        if ((multiArr[0][0] == 'X' && multiArr[0][0] == multiArr[0][1] && multiArr[0][0] == multiArr[0][2])
                || (multiArr[1][0] == 'X' && multiArr[1][0] == multiArr[1][1] && multiArr[1][0] == multiArr[1][2])
                || (multiArr[2][0] == 'X' && multiArr[2][0] == multiArr[2][1] && multiArr[2][0] == multiArr[2][2])
                || (multiArr[0][0] == 'X' && multiArr[0][0] == multiArr[1][0] && multiArr[0][0] == multiArr[2][0])
                || (multiArr[0][1] == 'X' && multiArr[0][1] == multiArr[1][1] && multiArr[0][1] == multiArr[2][1])
                || (multiArr[0][2] == 'X' && multiArr[0][2] == multiArr[1][2] && multiArr[0][2] == multiArr[2][2])
                || (multiArr[0][0] == 'X' && multiArr[0][0] == multiArr[1][1] && multiArr[0][0] == multiArr[2][2])
                || (multiArr[0][2] == 'X' && multiArr[0][2] == multiArr[1][1] && multiArr[0][2] == multiArr[2][0])) {
            System.out.println("X wins");
            end = true;
        } else if ((multiArr[0][0] == 'O' && multiArr[0][0] == multiArr[0][1] && multiArr[0][0] == multiArr[0][2])
                || (multiArr[1][0] == 'O' && multiArr[1][0] == multiArr[1][1] && multiArr[1][0] == multiArr[1][2])
                || (multiArr[2][0] == 'O' && multiArr[2][0] == multiArr[2][1] && multiArr[2][0] == multiArr[2][2])
                || (multiArr[0][0] == 'O' && multiArr[0][0] == multiArr[1][0] && multiArr[0][0] == multiArr[2][0])
                || (multiArr[0][1] == 'O' && multiArr[0][1] == multiArr[1][1] && multiArr[0][1] == multiArr[2][1])
                || (multiArr[0][2] == 'O' && multiArr[0][2] == multiArr[1][2] && multiArr[0][2] == multiArr[2][2])
                || (multiArr[0][0] == 'O' && multiArr[0][0] == multiArr[1][1] && multiArr[0][0] == multiArr[2][2])
                || (multiArr[0][2] == 'O' && multiArr[0][2] == multiArr[1][1] && multiArr[0][2] == multiArr[2][0])) {
            System.out.println("O wins");
            end = true;
        } else if (count == 9) {
            System.out.println("Draw");
            end = true;
        }
        return end;
    }

}
