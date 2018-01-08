package cs.bigdata.Lab2.round1;
import org.apache.hadoop.mapreduce.Reducer;
import cs.bigdata.Lab2.utils.WordDoc;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;

public class TfIdfRound1Reducer extends Reducer<WordDoc, IntWritable, WordDoc, IntWritable> {

    private IntWritable totalWordCount = new IntWritable();

    @Override
    public void reduce(final WordDoc key, final Iterable<IntWritable> values,
            final Context context) throws IOException, InterruptedException {
    		
    		// This value keeps track of the number of words
        int wordCountInt = 0;
        Iterator<IntWritable> iterator = values.iterator();

        while (iterator.hasNext()) {
        		// Increment of 1
        		wordCountInt += iterator.next().get();
        }

        totalWordCount.set(wordCountInt);
        // Emit ([word, doc], wordCount)
        context.write(key, totalWordCount);
    }
}
