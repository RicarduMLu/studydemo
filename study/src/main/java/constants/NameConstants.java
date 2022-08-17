package constants;


import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class NameConstants {
    public static String name;

    static {
        try {
            name = Files.asCharSource(new File("E:\\File\\JavaText\\studydemo\\study\\src\\main\\resources\\名字\\name.txt"), Charsets.UTF_8).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String name古代;

    static {
        try {
            name古代 = Files.asCharSource(new File("E:\\File\\JavaText\\studydemo\\study\\src\\main\\resources\\名字\\name古代.txt"), Charsets.UTF_8).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String name8090;

    static {
        try {
            name8090 = Files.asCharSource(new File("E:\\File\\JavaText\\studydemo\\study\\src\\main\\resources\\名字\\name8090.txt"), Charsets.UTF_8).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String name0010;

    static {
        try {
            name0010 = Files.asCharSource(new File("E:\\File\\JavaText\\studydemo\\study\\src\\main\\resources\\名字\\name0010.txt"), Charsets.UTF_8).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NameConstants() throws IOException {
    }
}
