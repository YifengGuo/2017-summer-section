package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Get122TracesActivityIndex {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		/* input1: 122tracesOrigin.csv to get activities' index in List a */
		String filePath ="/Users/guoyifeng/Downloads/getSequentialPattern/122tracesOrigin.csv";

		/*
		 * input2: to reverse sequential pattern in number format back to string
		 * format
		 */
		//String filePath = "output/test.txt";
//
		/*
		 * input1-2: 122tracesGenerated.csv to get activities' index in List a
		 */
		//String filePath = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA/122Generated.csv";
		
		/*
		 * input1-3: 122+122traces_ori_gen.csv to get mixed activities' index in List a
		 */
//		String filePath = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA/122+122traces_ori_gen.csv";
		
		/*
		 * input1-4: 122HeuristicGeneratedSequences to get mixed activities' index in List a
		 */
		//String filePath = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Heuristic/122HeuristicGeneratedSequences.txt";
		
		/*
		 * input1-5: Random122GeneratedTraces to get mixed activities' index in List a
		 */
		//String filePath = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Random122From5000/Random122GeneratedTraces2.csv";
		
		/*
		 * input 1.6 Random122GeneratedTraces of Allen's updated algo
		 */
		//String filePath ="/Users/guoyifeng/Downloads/getSequentialPattern/122tracesOrigin.csv";
		//String filePath = "/Users/guoyifeng/Downloads/Update/122generatedTraces.csv";
		
		/*
		 * input 1.7 123 new processed original data and 123 new processed generated dataset
		 */
		//String filePath = "/Users/guoyifeng/Downloads/124NewProcessedSimplifiedData/123OriginTraces.txt";
//		String filePath = "/Users/guoyifeng/Downloads/124NewProcessedSimplifiedData/123GeneratedTraces.txt";
		
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String[]> arr = new ArrayList<>(); // to store input1
		//ArrayList<String> arr2 = new ArrayList<>(); // to store input2
		String line = "";
		String[] b;
		String splitBy = ","; // to read input1;
		//String splitBy = "#SUP"; // to read input2 to get sequential patten without #sup
		while ((line = br.readLine()) != null) {
			b = line.split(splitBy);
			arr.add(b); // input1
			//arr2.add(b[0]);// input2
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
		
		/**
		 * to check the input2 is stored normally
		 */
//		for (int i = 0; i < arr2.size(); i++) {
//			System.out.println(arr2.get(i));
//		}


		/* 122 traces */
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
		
//		/* 123 new processed dataset*/
//		 List<String> a = new ArrayList<String>(
//		 		Arrays.asList("bair_hugger_preparation_ec","yankauer_suction_preparation_ro","oxygen_preparation_bc","pt_arrival","pre_cnmc_tasks","ems_c_collar_cs","visual_assessment_aa","verbal_assessment_aa","passive_oxygen_applied_bc","oxygen_bc","oxygen_held_bc","chest_auscultation_ba","r_dp_pt_pc","pulse_ox_placement_ba","l_dp_pt_pc","oxygen_removed_bc","pulse_oximetry_os","cardiac_lead_placement_ca","r_brachial_radial_pc","l_brachial_radial_pc","verbal_assessed_gcs","eyes_assessed_gcs","clothing_removed_ec","eyes_verbalized_gcs","verbal_verbalized_gcs","motor_assessed_gcs","warm_sheet_placement_ec","total_verbalized_gcs","abp_cuff_placement_ca","right_pupil_pu","left_pupil_pu","mbp_bp","temperature_ea","abp_bp","palpation_h","palpation_f","palpation_n","light_inspection_n","r_otoscopy_ear","l_otoscopy_ear","palpation_ne","palpation_c","palpation_a","stability_pe","palpation_rle","joints_ranged_rle","visual_inspection_lle","palpation_lle","blood_drawn_sa","joints_ranged_lle","ems_c_collar_removal_cs","miami_j_collar_application_cs","miami_j_collar_cs","log_roll_bk","c_spine_bk","t_spine_bk","l_spine_bk","rectal_bk","pain_medication_sa","bair_hugger_ec","cxr_sa","pt_departure","warm_sheet_preparation_ec","manual_in_line_cs","motor_verbalized_gcs","light_inspection_m","iv_placement_cc","palpation_rue","manual_inspection_g","palpation_lue","joints_ranged_lue","joints_ranged_rue","c_spine_clearance_sa","palpation_m","capillary_refill_cr","iv_bolus_connected_b","iv_bolus_given_b","miami_j_collar_adjustment_cs","non_warm_sheet_placement_ec","warm_sheet_ec","warm_sheet_intentionally_removed_ec","non_warm_sheet_intentionally_removed_ec"));
//

		/**
		 * to print the activity index in a for input1
		 */
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).length; j++) {
				System.out.print(a.indexOf(arr.get(i)[j]) + " -1 ");
			}
			System.out.print(-2);
			System.out.println();
		}

		
		/**
		 * to reverse sequential pattern in number format back to string format
		 */
//		String filePath2 = "output/test.txt";
////
//		try {
//			br = new BufferedReader(new FileReader(filePath2));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////
//		ArrayList<String[]> arr3 = new ArrayList<>(); // to store input1
//		String line2 = "";
//		String[] b2;
//		String splitBy2 = " ";
//		while ((line2 = br.readLine()) != null) {
//			b2 = line2.split(splitBy2);
//			arr3.add(b2); // input2
//		}
//		br.close();
//		for (int i = 0; i < arr3.size(); i++) {
//			for (int j = 0; j < arr3.get(i).length; j++) {
//				System.out.print(arr3.get(i)[j] + " ");
//			}
//			System.out.println();
//		}
		
//		for (int i = 0; i < arr3.size(); i++) {
//			for (int j = 0; j < arr3.get(i).length; j++) {
//				System.out.print(a.get(Integer.parseInt(arr3.get(i)[j])) + " ");
//			}
//			System.out.println();
//		}
	
		
		//System.out.println(a.get(Integer.parseInt(arr3.get(68)[1])));
	}

}
