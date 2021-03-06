/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucene;



import java.util.HashMap;
import java.util.Map;

public class DocumentVector {
    Map<String, Integer> wordMap = new HashMap<String, Integer>();

    public void incCount(String word) {
        Integer oldCount = wordMap.get(word);
        wordMap.put(word, oldCount == null ? 1 : oldCount + 1);
    }

    double getCosineSimilarityWith(DocumentVector otherVector) {
        double innerProduct = 0;
        for(String w: this.wordMap.keySet()) {
            innerProduct += this.getCount(w) * otherVector.getCount(w);
        }
        return innerProduct / (this.getNorm() * otherVector.getNorm());
    }

    double getNorm() {
        double sum = 0;
        for (Integer count : wordMap.values()) {
            sum += count * count;
        }
        return Math.sqrt(sum);
    }

    int getCount(String word) {
        return wordMap.containsKey(word) ? wordMap.get(word) : 0;
    }

    public static void main(String[] args) {
        String doc1 = "N O V A G I N A";
        String doc2 = "N O L V A G I N A";

        DocumentVector v1 = new DocumentVector();
        for(String w:doc1.split("[^a-zA-Z]+")) {
            v1.incCount(w);
        }

        DocumentVector v2 = new DocumentVector();
        for(String w:doc2.split("[^a-zA-Z]+")) {
            v2.incCount(w);
        }

        System.out.println("Similarity = " + v1.getCosineSimilarityWith(v2));
    }

}