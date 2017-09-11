package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDifferenceNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		ArrayList<String[]> arr1 = new ArrayList<>();
		ArrayList<String[]> arr2 = new ArrayList<>();
		
		String file1 = "output/first_half_44.csv";
		String file2 = "output/second_half_44.csv";
		
		try {
			br1 = new BufferedReader(new FileReader(file1));
			br2 = new BufferedReader(new FileReader(file2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line1 = "";
		String line2 = "";
		String[] b1;
		String[] b2;
		String splitBy = ","; // to read input1;
		//String splitBy = "#SUP"; // to read input2
		while ((line1 = br1.readLine()) != null) {
			b1 = line1.split(splitBy);
			arr1.add(b1); // input1
			//arr2.add(b[0]);// input2
		}
		while ((line2 = br2.readLine()) != null) {
			b2 = line2.split(splitBy);
			arr2.add(b2); // input1
			//arr2.add(b[0]);// input2
		}
		br1.close();
		br2.close();
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
		int count = 0;
		for(int i = 0; i < arr1.size(); i++) {
			for(int j = 0; j < Math.max(arr1.get(i).length,arr2.get(i).length); j++) {
				if(arr1.get(i)[j].contentEquals(arr2.get(i)[j])) {
					System.out.print("Match ");
				}
				else System.out.print(a.get(j) + " ");
			}
			System.out.println();
		}
		//System.out.println(count);

	}

}
