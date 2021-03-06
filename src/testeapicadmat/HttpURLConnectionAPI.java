/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeapicadmat;

/**
 *
 * @author roliveira
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionAPI {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        HttpURLConnectionAPI http = new HttpURLConnectionAPI();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();

        //System.out.println("\nTesting 2 - Send Http POST request");
        //http.sendPost();
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url =   "http://compras.dados.gov.br/materiais/v1/materiais.json?grupo=65";
        
        
        //http://compras.dados.gov.br/materiais/v1/materiais.json

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        Long i = new Long(0);
        while ((inputLine = in.readLine()) != null) {
           response.append(inputLine);

        }

        
           InputStream inzip =  con.getInputStream();
            //System.out.println(inzip.available());
  
            FileOutputStream out = new FileOutputStream("I:\\tmppdf\\cvm.zip");
            byte[] buff = new byte[4096];
            int len = 0;
            while ((len = inzip.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        
        
        
        BufferedWriter  arquivo = new BufferedWriter(new FileWriter ("I://cvm.txt"));
        arquivo.write(response.toString());
           in.close();
        /*String texto = response.toString();
        char[] result = new char[texto.length()];
         for (; i <= texto.length(); i++) {
                if (texto.charAt(i) == ',') {
                    
                result[i]= '\r';
                } else {
                      result[i]= texto.charAt(i);
                }

            }
         System.out.println(result);
       //System.out.println(response.toString());
*/

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

}
