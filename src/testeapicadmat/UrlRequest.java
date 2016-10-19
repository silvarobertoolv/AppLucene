/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeapicadmat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 *
 * @author roliveira
 */
public class UrlRequest {
    
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        String url = args[0];
        String filePath = args[1];
URL website = new URL(url);
ReadableByteChannel rbc = Channels.newChannel(website.openStream());
FileOutputStream fos = new FileOutputStream(filePath);
fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        
        
    }
    
}
