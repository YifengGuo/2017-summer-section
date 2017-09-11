package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Get122traces_Activity_Frequency {

	public static void main(String[] args) {
		ArrayList<String> act = null;
		try {
			act = new ArrayList<String>();
			String splitBy = "#SUP";
			//String splitBy = "	";
			BufferedReader br = new BufferedReader(new FileReader("output/test.txt"));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] b = line.split(splitBy);
				act.add(b[0].trim());
				//act.add(line.trim());
				System.out.println(b[0]);
//				for(int i = 0; i < b.length; i++) {
//					System.out.print(b[i] + ", ");
//				}
			}
//			for(int i = 0; i < act.size(); i++) {
//				System.out.print("\""+act.get(i)+"\", ");
//			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

