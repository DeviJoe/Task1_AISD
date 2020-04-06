package com.devijoe.project;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Style {

    private List<StringBuilder> paragraph = new ArrayList<>();

    private int startIndex;
    private int endIndex;
    boolean isNumeration;


    public List<StringBuilder> getParagraph() {
        return paragraph;
    }

    public void setParagraph(List<StringBuilder> paragraph) {
        this.paragraph = paragraph;
    }

    /**
     * Добавление строки в параграф
     * @param stringBuilder строка
     */
     public void add(StringBuilder stringBuilder) {
        paragraph.add(stringBuilder);
     }

    /**
     * Метод заполняет маркированный список
     * @param startIndex начальный индекс строки списка
     * @param endIndex конечный индекс строки списка
     * @param isNumeration признак нумерованного списка
     */
     public void markedList(int startIndex, int endIndex, boolean isNumeration) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.isNumeration = isNumeration;

        setMarkedList();
     }

    private void setMarkedList() {
         int index = 1;
         String str;
         for (int i=startIndex; i<=endIndex; i++) {
             if (isNumeration) {
                 str = index + ") " + paragraph.get(i);
                 paragraph.add(i, new StringBuilder(str));
                 index++;
             } else {
                 str = "* " + paragraph.get(i);
                 paragraph.add(i, new StringBuilder(str));
             }
         }
     }

    /**
     * Подключает стиль к используемому документу для дальнейшего использования
     * @param object объект для подключения
     */
    public void useStyle(List<StringBuilder> object) {
        super.object = object;
    }
}
