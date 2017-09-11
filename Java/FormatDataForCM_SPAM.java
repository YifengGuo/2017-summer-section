package SemiSyntheticDataGenerator.fetch_sequential_pattern;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatDataForCM_SPAM {
	public static String filePath ="/Users/guoyifeng/Downloads/getSequentialPattern/122tracesOrigin.csv";
	String formattedDataFile = "";
	public static void main(String[] args) throws IOException {
		String s = new FormatDataForCM_SPAM(filePath).getFormattedDataSet();
		System.out.println(s);
	}
	
	public FormatDataForCM_SPAM(String filePath) throws IOException{
		BufferedReader br = null;
		BufferedWriter bw = null;
		/* input1: 122tracesOrigin.csv to get activities' index in List a */
		
		
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String[]> arr = new ArrayList<>(); // to store input1
		String line = "";
		String[] b;
		String splitBy = ","; // to read input1;
		while ((line = br.readLine()) != null) {
			b = line.split(splitBy);
			arr.add(b); // input1
		}
		br.close();

		/**
		 * to check the input1 is stored normally
		 */
//		for (int i = 0; i < arr.size(); i++) {
//			for (int j = 0; j < arr.get(i).length; j++) {
//				System.out.print(arr.get(i)[j] + " ");
//			}
//			System.out.println();
//		}
		
		/* 122 traces activities*/
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

		/**
		 * to print the activity index in a for input1
		 */
//		for (int i = 0; i < arr.size(); i++) {
//			for (int j = 0; j < arr.get(i).length; j++) {
//				System.out.print(a.indexOf(arr.get(i)[j]) + " -1 ");
//			}
//			System.out.print(-2);
//			System.out.println();
//		}
		
		/**
		 * to output the formated dataset in a certain file as the future input of CM_SPAM
		 */
		File formattedData = new File("formattedData");
        if(!formattedData.exists()) {
            System.out.println("Creating directory: " + formattedData.getName());
            boolean created = false;// if the file has been created
            try {
            	formattedData.mkdir();
                created = true;
            } catch(SecurityException e) {
                e.printStackTrace();
            }

            if(created) {
                System.out.println("File " + formattedData.getName() +" created.");
            }
        }
        formattedDataFile = "formattedData/input1";
        bw = new BufferedWriter(new FileWriter(formattedDataFile + ".txt"));
        for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).length; j++) {
				bw.write(a.indexOf(arr.get(i)[j]) + " -1 ");
			}
			bw.write("-2");
			bw.write("\n");
		}
        bw.close();
	}
	
	public String getFormattedDataSet() {
		return formattedDataFile + ".txt";
	}
}
