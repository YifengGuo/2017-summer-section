package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class FindDuplicatesActivityInTraces {

	public static void main(String[] args) throws IOException {
		BufferedReader br1 = null;
		//BufferedReader br2 = null;
		//ArrayList<String> arr1 = new ArrayList<>();
		Hashtable<Integer,ArrayList<String>> h1 = new Hashtable<>();
		HashSet<String> s1 = new HashSet<>();
		//ArrayList<String[]> arr2 = new ArrayList<>();
		
		//String file = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Random122From5000/5000GeneratedTraces.csv";
		String file = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Random122From5000/122tracesOrigin.csv";
		
		try {
			br1 = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line1 = "";
		String line2 = "";
		String[] b1;
		String[] b2;
		String splitBy = ","; // to read input1;
		int key = 0;
		while ((line1 = br1.readLine()) != null) {
			ArrayList<String> arr1 = new ArrayList<>();
			b1 = line1.split(splitBy);
			for(int i = 0; i < b1.length; i++) {
				arr1.add(b1[i].trim());
			}
			s1.add(line1.trim());//hashset
			h1.put(key, arr1);//hashtable to find activity frequency
			key++;
			//arr1.add(line1.trim().replaceAll(",", " "));
			//arr1.add(b1); // input1
			//arr2.add(b[0]);// input2
		}
		/*
		 *  check if activities are stored normally;
		 */

		br1.close();
//		br2.close();
		List<String> a = new ArrayList<String>(Arrays.asList("Pt_arrival", "Visual_assessment_AA",
				"Chest_Auscultation_BA", "R_DP_PT_PC", "Total_Verbalized_GCS", "Right_pupil_PU", "Left_pupil_PU",
				"Visual_inspection_H", "Palpation_H", "Palpation_F", "Visual_inspection_F", "L_Visual_inspection_EAR",
				"Visual_inspection_N", "R_Visual_inspection_EAR", "R_otoscopy_EAR", "Visual_inspection_M",
				"Palpation_NE", "Visual_inspection_NE", "L_otoscopy_EAR", "Palpation_C", "Visual_inspection_C",
				"Palpation_A", "Visual_inspection_A", "Stability_PE", "Palpation_RLE", "Visual_inspection_RLE",
				"Palpation_LLE", "Visual_inspection_LLE", "Palpation_LUE", "Visual_inspection_LUE", "Palpation_RUE",
				"Visual_inspection_RUE", "Log_roll_BK", "Rectal_BK", "Pt_departure", "Verbal_assessment_AA",
				"C_spine_BK", "Visual_inspection_G", "Visual_inspection_BK", "T_spine_BK", "L_spine_BK", "L_DP_PT_PC",
				"L_visual_inspection_EY", "R_visual_inspection_EY"));
		
		
		
//		for(int i = 0; i < arr1.size(); i++) {
//			for(int j = 0; j < arr1.get(i).length; j++) {
//				for(int k = 0; k < a.size(); k++) {
//					if(arr1.get(i)[j].trim().contentEquals(a.get(k))) {
//					}
//				}
//			}
//			System.out.println();
//		}
//		
//		for(int i = 0; i < h1.size(); i++) {
//			System.out.print(h1.get(i) + " " );
//		}
		
		/* FindDuplicatesActivityInTraces */
		for(int i = 0; i < h1.size(); i++) {
			for(int j = 0; j < a.size(); j++) {
				System.out.print(a.get(j)+" "+Collections.frequency(h1.get(i), a.get(j)) + " ");
			}
			System.out.println();
		}

//	}
		
		/* to check if there exists duplicate trace in generated data traces */
//		Iterator<String> it = s1.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
	

	}
}

