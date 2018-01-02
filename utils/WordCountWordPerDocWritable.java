package cs.bigdata.Lab2.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class WordCountWordPerDocWritable implements Writable{
	
	private IntWritable wordCount;
	private IntWritable wordPerDoc;
	
	public WordCountWordPerDocWritable() {
		super();
		this.wordCount = new IntWritable();
		this.wordPerDoc = new IntWritable();
	}


	public WordCountWordPerDocWritable(IntWritable wordCount, IntWritable wordPerDoc) {
		super();
		this.wordCount = wordCount;
		this.wordPerDoc = wordPerDoc;
	}
	
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		wordCount.readFields(arg0);
		wordPerDoc.readFields(arg0);
	}
	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		wordCount.write(arg0);
		wordPerDoc.write(arg0);
	}
	
	public String toString() {
		return "(" + wordCount + ", " + wordPerDoc + ")";
	}

	
}
