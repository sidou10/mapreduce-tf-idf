package cs.bigdata.Lab2.utils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class DocWordCountWordPerDocWritable implements Writable{
	
	private Text doc;
	private IntWritable wordCount;
	private IntWritable wordsPerDoc;
	
	public DocWordCountWordPerDocWritable(Text doc, IntWritable wordCount, IntWritable wordsPerCount) {
		super();
		this.doc = doc;
		this.wordCount = wordCount;
	}
	
	public DocWordCountWordPerDocWritable(Text doc, String wordCount, String wordsPerCount) {
		super();
		this.doc = doc;
		this.wordCount = new IntWritable(Integer.parseInt(wordCount));
		this.wordsPerDoc = new IntWritable(Integer.parseInt(wordsPerCount));
	}
	public Text getDoc() {
		return doc;
	}

	public void setDoc(Text doc) {
		this.doc = doc;
	}

	public DocWordCountWordPerDocWritable() {
		super();
		this.doc = new Text();
		this.wordCount = new IntWritable();
		this.wordsPerDoc = new IntWritable();
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		wordCount.readFields(arg0);
		doc.readFields(arg0);
		wordsPerDoc.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		wordCount.write(arg0);
		doc.write(arg0);
		wordsPerDoc.write(arg0);
	}

	public IntWritable getWordCount() {
		return wordCount;
	}

	public void setWordCount(IntWritable wordCount) {
		this.wordCount = wordCount;
	}

	public IntWritable getWordsPerDoc() {
		return wordsPerDoc;
	}

	public void setWordsPerDoc(IntWritable wordsPerCount) {
		this.wordsPerDoc = wordsPerCount;
	}
	
	
}
