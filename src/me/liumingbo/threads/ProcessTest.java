package me.liumingbo.threads;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by liumingbo on 2016/12/8.
 * Email:liumingbo2008@gmail.com
 */
public class ProcessTest {
    public static void main(String[] args) throws IOException {
        /*
        * 创建进程
        * */
//        ProcessBuilder pb = new ProcessBuilder("cmd","/c","ipconfig/all");
//        Process process = pb.start();
//        Scanner scanner = new Scanner(process.getInputStream());
//
//        while (scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }
//        scanner.close();
        String cmd = "cmd " + "/c " + "ipconfig/all";
        Process process = Runtime.getRuntime().exec(cmd);
        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine())

        {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

}
