package cs.bigdata.Lab2.round2;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

import cs.bigdata.Lab2.utils.WordCountWordPerDocWritable;
import cs.bigdata.Lab2.utils.WordDoc;
import cs.bigdata.Lab2.utils.WordWordCountWritable;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.io.IntWritable;


public class TfIdfRound2Reducer extends Reducer<Text, WordWordCountWritable, WordDoc, WordCountWordPerDocWritable> {

    private IntWritable wordsPerDoc = new IntWritable();
    
    @Override
    public void reduce(final Text key, final Iterable<WordWordCountWritable> values,
            final Context context) throws IOException, InterruptedException {
    		
    		// Variable that keep track of the number of words in the received document
        int wordsPerDocInt = 0;
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> wordCounts = new ArrayList<Integer>();
        
        for (WordWordCountWritable wwc: values) {
        		wordsPerDocInt += wwc.getWordCount().get();
            words.add(wwc.getWord().toString());
            wordCounts.add(wwc.getWordCount().get());
        }
        
        wordsPerDoc.set(wordsPerDocInt);
        int length = words.size();
        
        // Emit ([word, docName], [wordCount, wordsPerDoc]) for each word x docName
        for (int i=0; i<length;i++) {
        		IntWritable wordCount = new IntWritable(wordCounts.get(i));
            context.write(new WordDoc(words.get(i), key), 
            		new WordCountWordPerDocWritable(wordCount, wordsPerDoc));
        }
    }
}
