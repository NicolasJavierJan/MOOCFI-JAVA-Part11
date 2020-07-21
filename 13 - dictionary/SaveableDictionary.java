/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Nico
 */

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private String file;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file){
        this.file = file;
        this.dictionary = new HashMap<>();
    }
    
    public boolean load(){
        try (Scanner fileReader = new Scanner(Paths.get(this.file))){
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public void add(String word, String translation){
        if (!this.dictionary.containsKey(word)){
            this.dictionary.put(word, translation);
            this.dictionary.put(translation, word);
        }
    }
    
    public String translate(String word){
        return this.dictionary.get(word);
    }
    
    public void delete(String word){
        String translation = this.dictionary.get(word);
        this.dictionary.remove(word);
        this.dictionary.remove(translation);
    }
    
    public boolean save(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.file);
            if (writer == null){
                return false;
            }
            HashMap<String, String> newDict = new HashMap<>();
            for (String words : this.dictionary.keySet()){
                if (!newDict.containsKey(words) && !newDict.containsValue(words)){
                    newDict.put(words, this.dictionary.get(words));
                }
            }   for (String word : newDict.keySet()){
                writer.println(word + ":" + newDict.get(word));
            }   return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveableDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
        return false;
    }
}
