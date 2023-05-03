package org.example.window;

import org.example.window.helper_classes.ButtonStart;
import org.example.window.helper_classes.MyMenuBar;
import org.example.window.helper_classes.OutputStreamEncoding;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class Window extends JFrame {

    public Window() throws UnsupportedEncodingException {
        setTitle("     Alfa-812");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();  // объявляем текстовое поле
        textArea.setBackground(new Color(220, 220, 220));  // цвет фона

        //Печатает текст в окно
        String STDOUT_ENCODING = "windows-1251";
        PrintStream printStream = new PrintStream(new OutputStreamEncoding(textArea, STDOUT_ENCODING),
                true, STDOUT_ENCODING);
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);  // вывод текста на экран с кнопки старт
        System.setErr(printStream); // вывод текста ошибок на экран с кнопки старт

        setJMenuBar(new MyMenuBar().menuBar(textArea));  // создаем меню

        // creates the GUI
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 1;  // по центру
        constraints.gridy = 0;
        constraints.fill = 1;  // заполняет пространство рядом с кнопкой.
        add(new ButtonStart().buttonStart(), constraints);  // добавляем пнопку start

        // окно для текста по центру
        constraints.gridx = 0;
        constraints.gridy = 1;  // координата по "у" окна.
        constraints.gridwidth = 2;  // разметка текстового окна
        constraints.fill = GridBagConstraints.BOTH;  //текстовое окно
        constraints.weightx = 1.0;  // разметка текстового окна
        constraints.weighty = 1.0;  // разметка текстового окна
        add(new JScrollPane(textArea), constraints);  // Добавляет текстовое поле.
        //Делает рамку вокруг
        constraints.insets = new Insets(10, 10, 10, 10);

        System.out.println("Нажимай кнопку. Откроется окно, по умолчанию Рабочий стол.");
        System.out.println("У тебя 2 попытки для открытия файла csv.");
        System.out.println();
    }

}
