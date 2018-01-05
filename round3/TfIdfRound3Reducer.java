package cs.bigdata.Lab2.round3;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
import cs.bigdata.Lab2.utils.DocWordCountWordPerDocWritable;
import cs.bigdata.Lab2.utils.WcWpdDpwWritable;
import cs.bigdata.Lab2.utils.WordDoc;
import java.io.IOException;
import java.util.ArrayList;

public class TfIdfRound3Reducer extends Reducer<Text, DocWordCountWordPerDocWritable, WordDoc, WcWpdDpwWritable> {

    @Override
    public void reduce(final Text key, final Iterable<DocWordCountWordPerDocWritable> values,
            final Context context) throws IOException, InterruptedException {
    		
    		// Count the number of documents the word appears in
        int docsPerWord = 0;
        
        ArrayList<String> docs = new ArrayList<String>();
        ArrayList<Integer> wordCounts = new ArrayList<Integer>();
        ArrayList<Integer> wordsPerDocs = new ArrayList<Integer>();
        
        for (DocWordCountWordPerDocWritable dwcwd: values) {
        		docsPerWord += 1;
            docs.add(dwcwd.getDoc().toString());
            wordCounts.add(dwcwd.getWordCount().get());
            wordsPerDocs.add(dwcwd.getWordsPerDoc().get());
        }
        
        int length = wordCounts.size();
        
        for(int i=0; i<length; i++) {
        		context.write(new WordDoc(key, docs.get(i)),
        				new WcWpdDpwWritable(wordCounts.get(i), wordsPerDocs.get(i), docsPerWord));
        }
    }
}
