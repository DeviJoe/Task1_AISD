package com.devijoe.project;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

public class MouseController {

    public interface MouseLine {
        int getRow(JTextComponent text) throws BadLocationException;
    }

    protected MouseLine mouseLine = new MouseLine() {
        @Override
        public int getRow(JTextComponent text) throws BadLocationException {

            return getRowByCaret(text);
        }
    };

    /**
     * Возвращает номер строки, в которой установлен курсор
     * @param text JTextComponent или наследник
     * @return номер строки
     * @throws BadLocationException
     */
    public static int getRowByCaret(JTextComponent text) throws BadLocationException {
        int caretPos = text.getCaretPosition();
        int rowNum = (caretPos == 0) ? 1 : 0;
        for (int offset = caretPos; offset > 0;) {
            offset = Utilities.getRowStart(text, offset) - 1;
            rowNum++;
        }
        return rowNum;
    }
}
