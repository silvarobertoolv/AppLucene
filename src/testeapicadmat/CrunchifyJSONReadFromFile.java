/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeapicadmat;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



 
/**
 * @author Crunchify.com
 */
 
public class CrunchifyJSONReadFromFile {
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(new FileReader(
                    "i:/cadmat.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("_links");
            String author = (String) jsonObject.get("self");
            JSONArray companyList = (JSONArray) jsonObject.get("desecricao");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}