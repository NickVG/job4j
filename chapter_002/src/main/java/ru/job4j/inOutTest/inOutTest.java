package ru.job4j.inOutTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class inOutTest extends OutputStream {
    private final OutputStream os;
    private final ByteArrayOutputStream baos;

    public inOutTest(OutputStream os) {
        this.os = os;
        this.baos = new ByteArrayOutputStream();
    }

    @Override
    public void write(int b) throws IOException {
        os.write(b);
        baos.write(b);
    }

    public static void main(String[] args) {
        inOutTest mos = new inOutTest(System.out);
        System.setOut(new PrintStream(mos));

        System.out.println("qwe");
        System.out.println("asd");
        System.out.println("zxc");

        System.err.println(mos.baos.toString());
    }
}