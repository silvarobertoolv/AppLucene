/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucene;

import java.io.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.Analyzer.TokenStreamComponents;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

public class TestAnalyzer  extends Analyzer{

    TestAnalyzer() {
        super();
    }

    protected TokenStreamComponents createComponents( String fieldName, Reader reader ) {
        String token;
        TokenStream result = null;

       // Tokenizer source = new WhitespaceTokenizer( Version.LUCENE_CURRENT, reader );
        Tokenizer source = new WhitespaceTokenizer();
        result = new ShingleFilter(source, 2, 2);

        return new TokenStreamComponents( source, result );

    }

    @Override
    protected TokenStreamComponents createComponents(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

