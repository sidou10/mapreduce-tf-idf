package cs.bigdata.Lab2.round4;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import cs.bigdata.Lab2.utils.WordDoc;
import java.io.IOException;

public class TfIdfRound4Mapper extends Mapper<LongWritable, Text, DoubleWritable, WordDoc> {
	
	private final float nbTotalDocs = 2;
	private DoubleWritable tfIdf = new DoubleWritable();
	private Text doc = new Text();

@Override
protected void map(LongWritable keyE, Text valE, Context context) throws IOException,InterruptedException
    {
		String line = valE.toString();		
		// Line format: (word, docName)	(wordCount, wordsPerDoc, docsPerWord)
		try {
			String[] keyValue = line.split("	");
			
			// Get the 2 info in value
			String[] value = keyValue[1].split(", ");
			float wordCount = Float.parseFloat(value[0].replace("(", ""));
			int wordsPerDoc = Integer.parseInt(value[1]);
			int docsPerWord = Integer.parseInt(value[2].replace(")", ""));
			
			// Get the 2 info in key
			String[] key = keyValue[0].split(", ");
			String wordString = key[0].replace("(", "");
			doc.set(key[1].replace(")", ""));
			
			double tfIdfDouble = wordCount/wordsPerDoc*Math.log(nbTotalDocs/docsPerWord);
			tfIdf.set(tfIdfDouble);
			// Prepare the data and emit (word, [docName, wordCount, wordsPerDoc])
			context.write(tfIdf, new WordDoc(wordString,doc));
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






