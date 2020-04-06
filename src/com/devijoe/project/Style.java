package com.devijoe.project;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 *     Объектное представление текстового документа (секции, списки) с форматированием текста в plain text.
 *     Классы - Параграф, Стиль и Документ.
 *     У Стиля свойтва: отступы сверху, снизу, слева, справа, красная строка (измеряется в кол-ве строк или символов),
 *     выравнивание (влево/вправо/по центру/по ширине), признак списка (с номером или с маркером).
 *     Параграф наследуется от стиля, а также может иметь стиль (собственные параметры параграфа перекрывают параметры стиля).
 *     Кроме того, для параграфа может быть задан номер, с которого начинается нумерация.
 *     Документ - состоит из параграфов и может печатать/сохранять форматированный документ в текстовом виде.
 *
 */

public class Style {

    List<StringBuilder> object = new ArrayList<>();

    public enum TypeMargin {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public enum TypeAlignment {
        LEFT,
        RIGHT,
        CENTER,
        WIDTH
    }

    public void alignment(TypeAlignment typeAlignment) {
        if (typeAlignment == TypeAlignment.LEFT) {
            alignmentLeft();
        } else if (typeAlignment == TypeAlignment.RIGHT) {
            alignmentRight();
        } else if (typeAlignment == TypeAlignment.CENTER) {
            alignmentCenter();
        } else {
            alignmentWidth();
        }
    }

    public void margin(int symbols, TypeMargin typeMargin) {
        if (typeMargin == TypeMargin.LEFT) {
            marginLeft(symbols);
        } else if (typeMargin == TypeMargin.RIGHT) {
            marginRight(symbols);
        } else if (typeMargin == TypeMargin.UP) {
            marginUp(symbols);
        } else {
            marginDown(symbols);
        }
    }



    private void marginLeft(int symbols) {
        for (int i=0; i<object.size(); i++) {
            object.add(i, object.get(i).insert(0, ' '));
        }
    }

    private void marginRight(int symbols) {
        alignmentRight();
        for (int i=0; i<object.size(); i++) {
            object.get(i).append(' ');
        }
    }

    private void marginUp(int symbols) {
        for (int i=0; i<symbols; i++) {
            object.add(1, new StringBuilder(""));
        }
    }

    private void marginDown(int symbols) {
        for (int i=0; i<symbols; i++) {
            object.add(new StringBuilder(""));
        }
    }

    /**
     * Задает красную строку
     * @param symbols
     */
    public void setRedLine(int symbols) {
        StringBuilder s = new StringBuilder("");

        for (int i=0; i<symbols; i++) {
            s.append(" ");
        }

        s.append(object.get(1));

        object.add(1, s);

    }

    private void alignmentLeft() {
        int max = Utils.findMaxLengthOfLine(object);

        for (int i=0; i<object.size(); i++) {
            int j=0;
            while (object.get(i).charAt(j) == ' ') {
                object.get(i).deleteCharAt(j);
            }
        }
    }

    private void alignmentRight() {
        int max = Utils.findMaxLengthOfLine(object);

        for (int i=0; i<object.size(); i++) {
            int j=object.size()-1;
            while (object.get(i).charAt(j) == ' ') {
                object.get(i).deleteCharAt(j);
            }
        }
    }

    private void alignmentCenter() {
        alignmentLeft();
        int max = Utils.findMaxLengthOfLine(object)/2;
        int subLength;

        for (int i=0; i<object.size(); i++) {
            subLength = object.get(i).length()/2;

            for (int j=0; i<max-subLength; j++) {
                object.get(i).insert(0, ' ');
            }
        }
    }

    private void alignmentWidth() {

    }

}

