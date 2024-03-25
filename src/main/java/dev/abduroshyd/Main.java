package dev.abduroshyd;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

//created by @abduroshyd 25.03.2024 (AD)
public class Main {

    static String activeLang = "uz";
    static ClassLoader loader = Thread.currentThread().getContextClassLoader();
    static Properties props = new Properties();

    public static void main(String[] args) throws IOException {
        loadProperties(); // tilni o'zlashtirish uchun
        while (true) {

            selectLangSection();

            System.out.println(props.get("sysLang"));
        }
    }

    private static void loadProperties() throws IOException {
        String resourceName = "application-" + activeLang + ".properties";
        InputStream resourceStream = loader.getResourceAsStream(resourceName);
        props.load(resourceStream);
    }

    private static void selectLangSection() throws IOException {
        String[] lang = {"uz", "uk", "en"};

        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < lang.length; i++) {
            System.out.println(i + 1 + ". " + props.get("lang-" + lang[i]));
        }

        System.out.print(props.get("selectLang") + ": ");

        int langCode = scanner.nextInt();

        activeLang = lang[langCode - 1];
        loadProperties(); // tilni o'zlashtirib olish, runtime da
    }
}