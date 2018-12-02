package serializeAndSomePackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dataStructures.DSArrayIndexedList;
public class Serializer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wicca p1 = new Wicca(2, "gay", 2);
		Wicca p2 = new Wicca(2, "frik", 4);
		DSArrayIndexedList<Wicca> p3 = new DSArrayIndexedList<Wicca>();

		try {
			/*FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(p1);
			o.writeObject(p2);
			o.writeObject(p3);

			o.close();
			f.close();*/

			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Wicca pr1 = (Wicca) oi.readObject();
			Wicca pr2 = (Wicca) oi.readObject();
			DSArrayIndexedList<Wicca> pr3 = (DSArrayIndexedList<Wicca>) oi.readObject();

			System.out.println(pr1.toString());
			System.out.println(pr2.toString());
			System.out.println(pr3.toString());

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
