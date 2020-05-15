package gali;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		String s = "if(a == 2) { print(3); }";
		StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
		while(tokenizer.ttype != StreamTokenizer.TT_EOF) {
			tokenizer.nextToken();
			switch(tokenizer.ttype) {
			case StreamTokenizer.TT_WORD:
				System.out.println("Word: " + tokenizer.sval);
				break;
			case StreamTokenizer.TT_NUMBER:
				System.out.println("Number: " + tokenizer.nval);
				break;
			case StreamTokenizer.TT_EOF:
				break;
			default:
				System.out.println("Symbol: " + (char)tokenizer.ttype);				
			}
		}
//		Answer root = new Animal("Human");
//		try {
//			FileInputStream f = new FileInputStream("gali.ser");
//			root = (Answer) (new ObjectInputStream(f)).readObject();
//			f.close();
//		} catch (FileNotFoundException e) {
//		}
//		root = root.play(new MsgBoxUser());
//		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("gali.ser"));
//		o.writeObject(root);
//		o.close();
	}

}
