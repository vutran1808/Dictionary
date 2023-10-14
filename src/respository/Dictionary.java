/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package respository;

import dataAccess.DictionDao;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class Dictionary implements IDictionary{

    @Override
    public void addWord(Map<String, String> diction) {
        DictionDao.Instance().addWord(diction);
    }

    @Override
    public void removeWord(Map<String, String> diction) {
        DictionDao.Instance().deleteWord(diction);
    }

    @Override
    public void translate(Map<String, String> diction) {
        DictionDao.Instance().translate(diction);
    }
    
}
