package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class Get122TracesActivitiesEnumeration {

	public static void main(String[] args) {
		BufferedReader br = null;
		HashSet<String> hs = null;
		try {
			hs = new HashSet<String>();
			String splitBy = ",";
			br = new BufferedReader(new FileReader("/Users/guoyifeng/Downloads/122traces_02.27.17 copy.csv"));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] b = line.split(splitBy);
				hs.add(b[1]);
				//System.out.print(b);
				for(int i = 0; i < b.length; i++) {
					//System.out.println("\""+b[] + "\", ");
				}
			}
			br.close();
			Iterator<String> it = hs.iterator();
			int count = 0;
			while(it.hasNext()) {
				count++;
				System.out.println(it.next());
			}
			System.out.println(count);
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
