package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NGramInputFetcher {
	public static void main(String[] args) {
		BufferedReader br = null;
		String line = "";
		List<String> input = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("/Users/guoyifeng/Documents/myJava/MergedHiddenMarkovModel/src/SemiSyntheticDataGenerator/NGramData/122tracesOrigin.csv"));
			while((line = br.readLine()) != null) {
				input.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < input.size(); i++) {
			System.out.println(input.size());
		}
		
	}
}
