package cs.bigdata.Lab2.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class WcWpdDpwWritable implements Writable{

	private IntWritable wordCount;
	private IntWritable wordPerDoc;
	private IntWritable docsPerWord;
	
	public WcWpdDpwWritable() {
		super();
		this.wordCount = new IntWritable();
		this.wordPerDoc = new IntWritable();
		this.docsPerWord = new IntWritable();
	}


	public WcWpdDpwWritable(IntWritable wordCount, IntWritable wordPerDoc, IntWritable docsPerWord) {
		super();
		this.wordCount = wordCount;
		this.wordPerDoc = wordPerDoc;
		this.docsPerWord = docsPerWord;
	}
	
	public WcWpdDpwWritable(int wordCount, int wordPerDoc, int docsPerWord) {
		super();
		this.wordCount = new IntWritable(wordCount);
		this.wordPerDoc = new IntWritable(wordPerDoc);
		this.docsPerWord = new IntWritable(docsPerWord);
	}
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		wordCount.readFields(arg0);
		wordPerDoc.readFields(arg0);
		docsPerWord.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		wordCount.write(arg0);
		wordPerDoc.write(arg0);
		docsPerWord.write(arg0);
	}
	
	public String toString() {
		return "(" + wordCount + ", " + wordPerDoc + ", " + docsPerWord + ")";
	}

}
