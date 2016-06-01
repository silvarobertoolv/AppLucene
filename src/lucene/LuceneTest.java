/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucene;

import java.io.StringReader;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;




public class LuceneTest {

    public static void main(String[] args) throws Exception {

        TestAnalyzer analyzer = new TestAnalyzer();
          System.out.println("lucene.LuceneTest.main()");
        try {
            TokenStream stream = analyzer.tokenStream("field", new StringReader("This is a sample sentence."));
            CharTermAttribute termAtt = stream.addAttribute(CharTermAttribute.class);

            stream.reset();

            // print all tokens until stream is exhausted
            while (stream.incrementToken()) {
                System.out.println(termAtt.toString());
            }

            stream.end();
            stream.close();
         }
         catch (Exception ex) {
             ex.printStackTrace();
         }

    }
}
