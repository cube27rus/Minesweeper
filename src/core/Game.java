package core;

import core.controller.CountingMinesUnderPoint;
import core.controller.GenerateRandomMines;
import core.models.ObjectInCase;
import core.view.*;

import java.util.Scanner;

/**
 * Created by Cube27 on 19.07.2017.
 */
public class Game {

    Field gameField;
    Field userField;
    String messageFail = "BOOOOOOOOOOOOOOOM!";
    String messageWin = "YOU WINNER!";

    public Game(Field field) {
        this.gameField = field;
        this.userField = new Field(field.getSize());
    }

    public boolean playerTurn(int y, int x) {
        //подсчет мин вокруг точки
        int mineUnderPoint = CountingMinesUnderPoint.count(y, x, gameField);
        //если напоролись на мину
        if (mineUnderPoint == -1) {
            System.out.println(messageFail);
            return false;
        }
        //устанавливаем в юзер поле значение mineUnderPoint
        String objectToSet = String.valueOf(mineUnderPoint);
        userField.setObjectInCase(y, x, new ObjectInCase(objectToSet));
        ConsoleView.watchField(userField);
        return true;
    }

    public boolean start() {
        gameField = GenerateRandomMines.generateField(5, gameField);
        int fieldSize = gameField.getSize();
        //выводим на экран путое поле
        ConsoleView.watchField(userField);
        //продолжаем игру пока playerContinueGame == true
        boolean playerContinueGame = true;
        while (playerContinueGame) {
            //Считываем координаты желаемой точки с клавы
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Y: ");
            int inputY = in.nextInt();
            System.out.println("Enter X: ");
            int inputX = in.nextInt();
            //если введенные значения не верны
            if (inputX > fieldSize - 1 || inputX < 0 || inputY > fieldSize - 1 || inputY < 0) {
                System.out.println("Выход за пределы поля, потоврите ввод");
                continue;
            }
            playerContinueGame = this.playerTurn(inputY, inputX);
            if (Game.checkForNullCases(fieldSize, gameField, userField)) {
                return true;
            }

        }
        return playerContinueGame;
    }

    public static boolean checkForNullCases(int fieldSize, Field field1, Field field2) {
        Object[][] secondField = new Object[fieldSize][fieldSize];
        //обьединяем два массива и смотрим есть ли там пустые кейсы.
        for (int i = 0; i < fieldSize; i++) {
            for (int k = 0; k < fieldSize; k++) {

                if (field1.getField()[i][k] != null) {
                    secondField[i][k] = field1.getField()[i][k];
                }
                if (field2.getField()[i][k] != null) {
                    secondField[i][k] = field2.getField()[i][k];
                }
            }
        }
        for (int i = 0; i < fieldSize; i++) {
            for (int k = 0; k < fieldSize; k++) {
                if (secondField[i][k] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Игра с консольным интерфейсом
        Game newGame = new Game(new Field());
        if (newGame.start()) {
            System.out.println(newGame.messageWin);
        }
        ;


    }
}
