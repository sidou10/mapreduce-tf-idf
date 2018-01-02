package cs.bigdata.Lab2.round3;


import org.apache.hadoop.mapreduce.Job;  
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import cs.bigdata.Lab2.utils.DocWordCountWordPerDocWritable;

import java.io.IOException;
import java.util.StringTokenizer;

public class TfIdfRound3Mapper extends Mapper<LongWritable, Text, Text, DocWordCountWordPerDocWritable> {
	
	private Text doc = new Text();
	private Text word = new Text();

@Override
protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
		String line = valE.toString();		
		// Line format: (word, docName)	(wordCount, wordsPerDoc)
		try {
			String[] keyValue = line.split("	");
			
			// Get the 2 info in value
			String[] value = keyValue[1].split(", ");
			String wordCountString = value[0].replace("(", "");
			String wordsPerDocString = value[1].replace(")", "");
			
			// Get the 2 info in key
			String[] key = keyValue[0].split(", ");
			String wordString = key[0].replace("(", "");
			doc.set(key[1].replace(")", ""));
			
			// Prepare the data and emit (word, [docName, wordCount, wordsPerDoc])
			word.set(wordString);
			context.write(word, new DocWordCountWordPerDocWritable(doc, wordCountString, wordsPerDocString));
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






