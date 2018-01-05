package cs.bigdata.Lab2.round1;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import cs.bigdata.Lab2.utils.WordDoc;
import java.io.IOException;
import java.util.StringTokenizer;

public class TfIdfRound1Mapper extends Mapper<LongWritable, Text, WordDoc, IntWritable> {
	
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
// Overriding of the map method
@Override
protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
		String line = valE.toString().toLowerCase().replaceAll("[^a-z ]", "");
		
		StringTokenizer tokenizer = new StringTokenizer(line);
		
		FileSplit fileSplit = (FileSplit) context.getInputSplit();
		String filename = fileSplit.getPath().getName();
		
		while(tokenizer.hasMoreTokens())
		{
			word.set(tokenizer.nextToken());
			context.write(new WordDoc(word,filename), one);
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






