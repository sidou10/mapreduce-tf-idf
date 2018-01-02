package cs.bigdata.Lab2.utils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class WordDoc implements WritableComparable {
	
	private Text word;
	private Text doc;
	
	public WordDoc() {
		this.word = new Text();
		this.doc = new Text();
	}
	
	public WordDoc(Text word, Text doc) {
		super();
		this.word = word;
		this.doc = doc;
	}
	
	public WordDoc(String word, String doc) {
		super();
		this.word = new Text(word);
		this.doc = new Text(doc);
	}
	
	public WordDoc(String word, Text doc) {
		super();
		this.word = new Text(word);
		this.doc = doc;
	}
	
	public WordDoc(Text word, String doc) {
		super();
		this.word = word;
		this.doc = new Text(doc);
	}
	
	
	public Text getWord() {
		return word;
	}

	public void setWord(Text word) {
		this.word = word;
	}

	public Text getDoc() {
		return doc;
	}

	public void setDoc(Text doc) {
		this.doc = doc;
	}

	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		word.readFields(arg0);
		doc.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		word.write(arg0);
		doc.write(arg0);
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof WordDoc) {
			WordDoc wd = (WordDoc) arg0;
			int cmp = word.compareTo(wd.getWord());
			
			if (cmp != 0) {
				return cmp;
			}
			
			return doc.compareTo(wd.getDoc());
		}
		return 0;
	}
	
	public String toString() {
		return "(" + word + ", " + doc + ")";
	}

}
