package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NGramGeneration {
	public static void ngrams(Map<String,Integer> map,int n, String str) {
		String[] words = str.split(" ");
		for(int i = 0; i < words.length - n + 1; i++) {
			if(!map.containsKey(concat(words, i, i + n))) {
				map.put(concat(words, i, i + n), 0);
			}
			map.put(concat(words, i, i + n), map.get(concat(words, i, i + n)) + 1);
		}
		return;
	}

	public static String concat(String[] words, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++)
			sb.append((i > start ? " " : "") + words[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		BufferedReader br = null;
		String line = "";
		List<String> input = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(
					"/Users/guoyifeng/Documents/myJava/MergedHiddenMarkovModel/src/SemiSyntheticDataGenerator/NGramData/122Origin.txt"));
			while ((line = br.readLine()) != null) {
				input.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Integer> map = new HashMap<>();
		for(int j = 0; j < input.size(); j++) {
			for(int i = 0; i <= 1000; i++) {
				ngrams(map,i,input.get(j));
			}
		}
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry<String, Integer> pair = (Map.Entry)it.next();
	        if(pair.getValue() >= 0.1 * input.size()) {
	        	System.out.println(pair.getKey() + " = " + pair.getValue());
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
}
