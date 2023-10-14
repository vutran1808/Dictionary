/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.ScannerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DictionDao {

    private static DictionDao instance = null;
    ScannerFactory sc;

    public DictionDao() {
        sc = new ScannerFactory();
    }

    public static DictionDao Instance() {
        if (instance == null) {
            synchronized (DictionDao.class) {
                if (instance == null) {
                    instance = new DictionDao();
                }
            }
        }
        return instance;
    }

    public void addWord(Map<String, String> dictionary) {
        readFile(dictionary);
        String eng = sc.getString("English word: ");
        String vn = sc.getString("Vietnamese word: ");
        dictionary.put(eng, vn);
        writeFile(dictionary);
        dictionary.clear();
        System.out.println("Successful");
    }

    public void deleteWord(Map<String, String> dictionary) {
        readFile(dictionary);
        String word = searchWord(dictionary);
        if (word != null) {
            dictionary.remove(word);
            writeFile(dictionary);
            dictionary.clear();
        } else {
            System.out.println("Word not found");
        }
    }

    public void translate(Map<String, String> dictionary) {
        readFile(dictionary);
        String word = searchWord(dictionary);
        if (word != null) {
            System.out.println("Vietnamese: " + dictionary.get(word));
        } else {
            System.out.println("Word in't existed");
        }
    }

    public String searchWord(Map<String, String> dictonary) {
        String english = sc.getString("Enter English: ");
        return dictonary.containsKey(english) ? english : null;
    }

    public void readFile(Map<String, String> dictonary) {
        File file = new File("src\\model\\storage.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                String data[] = line.split(":");
                dictonary.put(data[0].trim(), data[1].trim());
                line = br.readLine();
            }
        } catch (Exception ex) {
        }
    }

    public void writeFile(Map<String, String> dictionary) {
        File file = new File("src\\model\\storage.txt");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String eng : dictionary.keySet()) {
                pw.println(eng + ": " + dictionary.get(eng));
            }
            pw.close();
        } catch (Exception e) {
        }
    }
}
