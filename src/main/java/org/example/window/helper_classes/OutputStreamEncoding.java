package org.example.window.helper_classes;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEncoding extends OutputStream{
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private final JTextArea textArea;
    private final String STDOUT_ENCODING;

    public OutputStreamEncoding(JTextArea textArea, String STDOUT_ENCODING) {
        this.textArea = textArea;
        this.STDOUT_ENCODING = STDOUT_ENCODING;
    }

    @Override
    public void write(int b) throws IOException {
        baos.write(b);
    }

    @Override
    public void flush() throws IOException {
        baos.flush();
        baos.close();
        textArea.append(baos.toString(STDOUT_ENCODING));
        baos.reset();
    }

}
