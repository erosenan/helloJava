package gali;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Answer root = new Animal("Human");
		try {
			FileInputStream f = new FileInputStream("gali.ser");
			root = (Answer) (new ObjectInputStream(f)).readObject();
			f.close();
		} catch (FileNotFoundException e) {
		}
		root = root.play();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("gali.ser"));
		o.writeObject(root);
		o.close();
	}

}
