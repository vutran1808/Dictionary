/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import respository.Dictionary;
import respository.IDictionary;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class DictionaryManager extends Menu {

    private Map<String, String> dictonary;
    IDictionary mn;
    static String[] mc = {"Add word", "Delete word", "Translate", "Exit"};

    public DictionaryManager() {
        super("Dictionary program", mc);
        mn = new Dictionary();
        dictonary = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> mn.addWord(dictonary);
            case 2 -> mn.removeWord(dictonary);
            case 3 -> mn.translate(dictonary);
            case 4 -> System.exit(0);
        }
    }
}
