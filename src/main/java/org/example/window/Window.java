package org.example.window;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Window extends JFrame {

    public Window() throws UnsupportedEncodingException {
        super("Програмка для Оли");

        /**
         * The text area which is used for displaying logging information.
         */
        JTextArea textArea = new JTextArea(50, 10);   // число строк и кол-во их
        textArea.setEditable(false);

        //Печатает текст в окно
        String STDOUT_ENCODING = "windows-1251";
        PrintStream printStream = new PrintStream(new OutputStreamEncoding(textArea, STDOUT_ENCODING),
                true, STDOUT_ENCODING);


        // re-assigns standard output stream and error output stream
        System.setOut(printStream);  // вывод текста на экран с кнопки старт
        System.setErr(printStream); // вывод текста ошибок на экран с кнопки старт

        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        //Делает рамку вокруг
        constraints.insets = new Insets(10, 10, 10, 10);
        //Делает кнопки рядом
        //constraints.anchor = GridBagConstraints.WEST;

        // Добавляем кнопку
        JButton buttonStart = new JButton("Жмякай");
        add(buttonStart, constraints);

        // если его нет, то кнопки одна на одной
        //constraints.gridx = 1;
        //add(buttonClear, constraints);

        // окно для текста по центру
        constraints.gridx = 0;
        constraints.gridy = 1;  // кнпки поверх текстового окна.
        constraints.gridwidth = 2;  // разметка текстового окна
        constraints.fill = GridBagConstraints.BOTH;  //текстовое окно
        constraints.weightx = 1.0;  // разметка текстового окна
        constraints.weighty = 1.0;  // разметка текстового окна

        add(new JScrollPane(textArea), constraints);  // Добавляет текстовое поле.

        System.out.println("Нажимай кнопку. Откроется окно, по умолчанию Рабочий стол.");
        System.out.println("У тебя 2 попытки для открытия файла csv.");
        System.out.println();

        buttonStart.addActionListener(new StartCommand());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 500);
        setLocationRelativeTo(null);    // centers on screen
    }

}
