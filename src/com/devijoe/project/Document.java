package com.devijoe.project;

import javax.print.Doc;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Document extends Style {

    //Документ с делением на параграфы
    private List<Paragraph> doc = new  ArrayList<>();
    //Документ без параграфов (используется для обощенного форматирования через Style)
    private List<StringBuilder> bareDoc = new  ArrayList<>();

    /**
     * Печать документа в консоль
     */
    public void print() {
        for (int i=0; i<doc.size(); i++) {
            for (int j=0; j<doc.get(i).getParagraph().size(); j++) {
                System.out.println(doc.get(i).getParagraph().get(j));
            }
        }
    }

    public List<StringBuilder> getBareDoc() {
        return bareDoc;
    }

    /**
     * Возвращает кол-во символов в документе
     * @return
     */
    public int sizeOfSymbols() {
        int s = 0;
        for (int i=0; i<doc.size(); i++) {
            for (int j=0; j<doc.get(i).getParagraph().size(); j++) {
                s++;
            }
        }
        return s;
    }

    /**
     * Возвращает строку текста
     * @param num порядковый номер строки
     * @return
     */
    public StringBuilder getLine(int num) {
        int i=0;
        while (num > doc.get(i).getParagraph().size()) {
            num -= doc.get(i).getParagraph().size();
            i--;
        }
        return doc.get(i).getParagraph().get(num);
    }

    /**
     * Изменяет строку в документе
     * @param num номер строки
     * @param s заменяемая строка
     */
    public void setLine(int num, StringBuilder s) {
        int i=0;
        while (num > doc.get(i).getParagraph().size()) {
            num -= doc.get(i).getParagraph().size();
            i--;
        }
        doc.get(i).getParagraph().add(num, s);
    }


    /**
     * Возвращает кол-во строк в документе
     * @return
     */
    public int sizeOfLines() {
        int s = 0;
        for (int i=0; i<doc.size(); i++) {
            s += doc.get(i).getParagraph().size();
        }
        return s;
    }
    /**
     * Получение документа для работы с ним
     * @return
     */
    public List<Paragraph> getDoc() {
        return doc;
    }

    /**
     * Сохранение в файл
     * @param path путь до файла
     * @throws IOException
     */
    public void saveOnFile(String path) throws IOException {
        for (int i=0; i<doc.size(); i++) {
            Files.write(Paths.get(path), doc.get(i).getParagraph());
        }
    }

    /**
     * Добавление параграфа
     * @param paragraph
     */
    public void add(Paragraph paragraph) {
        doc.add(paragraph);
    }

    public void add(int num, StringBuilder s) {
        int i=0;
        while (num > doc.get(i).getParagraph().size()) {
            num -= doc.get(i).getParagraph().size();
            i--;
        }
        doc.get(i).getParagraph().add(num, s);
    }

    /**
     * Подключает стиль к используемому документу для дальнейшего использования
     * @param object объект для подключения
     */
    public void useStyle(List<StringBuilder> object) {
        super.object = object;
    }

    /**
     * Обновляет документ после применения стилей
     */
    private void updateDoc() {
        for (int i=0; i < sizeOfLines(); i++) {
            setLine(i, bareDoc.get(i));
        }
    }

    @Override
    public void alignment(TypeAlignment typeAlignment) {
        super.alignment(typeAlignment);
        updateDoc();
    }

    @Override
    public void margin(int symbols, TypeMargin typeMargin) {
        super.margin(symbols, typeMargin);
        updateDoc();
    }

    @Override
    public void setRedLine(int symbols) {
        super.setRedLine(symbols);
        updateDoc();
    }


}
