/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package respository;

import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface IDictionary {
    void addWord(Map<String, String> diction);
    void removeWord(Map<String, String> diction);
    void translate(Map<String, String> diction);
}
