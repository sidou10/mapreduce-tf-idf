package cs.bigdata.Lab2.round2;


import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import cs.bigdata.Lab2.utils.WordWordCountWritable;

import java.io.IOException;
import java.util.StringTokenizer;

public class TfIdfRound2Mapper extends Mapper<LongWritable, Text, Text, WordWordCountWritable> {
	
	private Text doc = new Text();

@Override
protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
		String line = valE.toString();
		
		// Line format: (word, docName)	wordCount
		try {
			// Recover the 3 information in one line
			
			// Split line by tab to get key and value
			String[] keyValue = line.split("	");
			
			String wordCount = keyValue[1];
			
			// Split key by ", " to get word and docName
			String[] key = keyValue[0].split(", ");
			
			// Get word
			String wordString = key[0].replace("(", "");
			
			// Set docName
			doc.set(key[1].replace(")", ""));
			
			// Emit (docName, [word, wordCount] )
			context.write(doc, new WordWordCountWritable(wordString, wordCount));
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
    }

public void run(Context context) throws IOException, InterruptedException {
    setup(context);
    while (context.nextKeyValue()) {
        map(context.getCurrentKey(), context.getCurrentValue(), context);
    }
    cleanup(context);
}

}






