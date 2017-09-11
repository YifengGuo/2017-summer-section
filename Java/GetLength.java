package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetLength {
	public static void main(String[] args) {
		BufferedReader br = null;
		List<Integer> arr = new ArrayList<>();
		String line = "";
		try {
			br = new BufferedReader(new FileReader("output/hmm_heuristic_geneartedData_5000.txt"));
			while ((line = br.readLine()) != null) {
				arr.add(Integer.parseInt(line.split(" ")[0]));
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			if (!map.containsKey(arr.get(i))) {
				map.put(arr.get(i), 1);
			} else {
				map.put(arr.get(i), map.get(arr.get(i)) + 1);
			}
		}
		
//		for (int i = 0; i < map.size(); i++) {
//			System.out.println(map.get(arr.get(i)));
//		}
		List<Integer> arr2 = new ArrayList<>(map.values());
		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));
		}
	}
}
