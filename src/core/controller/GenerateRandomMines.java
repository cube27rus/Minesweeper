package core.controller;

import core.models.ObjectInCase;
import core.view.*;


/**
 * Created by Cube27 on 19.07.2017.
 */
public class GenerateRandomMines {
    //сгенерировать поле с минами
    public static Field generateField(int numOfMine, Field field) {
        Field fieldGenerator = field;
        int fieldSize = fieldGenerator.getSize() - 1;

        for (int i = 0; i < numOfMine; i++) {
            boolean mineIsSet = false;
            // расставляем мины на поле
            // цикл продолжается до тех пор, пока нужное кол-во мин не установятся в рандомные ячейки
            while (!mineIsSet) {
                int yRandomthis = GenerateRandomMines.generateRandomInt(0, fieldSize);
                int xRandomthis = GenerateRandomMines.generateRandomInt(0, fieldSize);
                mineIsSet = fieldGenerator.setObjectInCase(yRandomthis, xRandomthis, new ObjectInCase());
            }
        }
        return fieldGenerator;
    }

    public static int generateRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

}
