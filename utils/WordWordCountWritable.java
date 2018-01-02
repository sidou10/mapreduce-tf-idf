package cs.bigdata.Lab2.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class WordWordCountWritable implements Writable{

	private Text word;
	private IntWritable wordCount;
	
	
	
	public WordWordCountWritable() {
		super();
		this.word = new Text();
		this.wordCount = new IntWritable();
	}

	public WordWordCountWritable(Text word, IntWritable wordCount) {
		super();
		this.word = word;
		this.wordCount = wordCount;
	}
	
	public WordWordCountWritable(String word, String wordCount) {
		super();
		this.word = new Text(word);
		this.wordCount = new IntWritable(Integer.parseInt(wordCount));
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		word.readFields(arg0);
		wordCount.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		word.write(arg0);
		wordCount.write(arg0);
	}

	public IntWritable getWordCount() {
		return wordCount;
	}

	public void setWordCount(IntWritable wordCount) {
		this.wordCount = wordCount;
	}

	public Text getWord() {
		return word;
	}

	public void setWord(Text word) {
		this.word = word;
	}
	
	public String toString() {
		return "";
	}
}
