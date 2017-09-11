package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetSequentialPatternOccurrenceMatrix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br1 = null; // to read 122 traces activity sequnence
		BufferedReader br2 = null; // to read 304 rows sequential pattern
		
//		/* 122 traces origin */
//		String file1 = "output/122TracesActivityIndex.txt";
//		String file2 = "output/SequentialPattern0.1InNumber.txt";
//		
//		/* 122 traces origin */
//		String file3 = "output/122GeneratedSequences.txt";
//		String file4 = "output/122GeneratedSequentialPattern.txt";
//		
//		/* STACT 122 traces origin + generated */
//		String file5 = "output/ori_gen_mixed_activity_index.txt";
//		String file6 = "output/235_mixed_SequentialPattern_0525.txt";
//		
//		/* Heuristic 122 traces origin + generated*/ 
//		String file7 = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Heuristic/244HeuristicActivitiesSequencesWithout-1.txt";
//		String file8 = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Heuristic/min_sup0.3SequentialPattern.txt";
		
		/* 122Random Generated from 5000 with 122 Origin data*/ 
//		String file9 = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Random122From5000/244TracesInNumberFormatVersion2.txt";
//		String file10 = "/Users/guoyifeng/Downloads/MatlabPlotForModel/PCA_Random122From5000/244SequentialPatternWithout-1Version2.txt";
		
		/* 122Random Generated from Allen's update algo with 122 original data */
//		String file11 = "/Users/guoyifeng/Downloads/Update/122Origin+122GeneratedWithout-1.txt";
//		String file12 = "/Users/guoyifeng/Downloads/Update/SequentialPatternWithout-1.txt";
		
		/* 123 new processed dataset */
//		String file13 = "/Users/guoyifeng/Downloads/124NewProcessedSimplifiedData/123origin+123generatedIWithout-1Form.txt";
//		String file14 = "/Users/guoyifeng/Downloads/124NewProcessedSimplifiedData/123+123SequentialPattern.txt";
		
		/* 123 new processed dataset with 0.4 Min Support*/
//		String file15 = "/Users/guoyifeng/Downloads/124NewProcessedSimplifiedData/MinSup0.4/123origin+123generatedIWithout-1Form.txt";
//		String file16 = "/Users/guoyifeng/Downloads/124NewProcessedSimplifiedData/MinSup0.4/SequentialPattern0.4.txt";
		/* 122 traces heuristic dataset with 0.1 min sup*/
		String file17 = "/Users/guoyifeng/Downloads/MatlabPlotForModel/HMM_122tracesHeuristic_SequentialPattern/122+122Without-1.txt";
		String file18 = "/Users/guoyifeng/Downloads/MatlabPlotForModel/HMM_122tracesHeuristic_SequentialPattern/sequentialpattern.txt";
//		br1 = new BufferedReader(new FileReader(file1));
//		br2 = new BufferedReader(new FileReader(file2));
		
		br1 = new BufferedReader(new FileReader(file17));
		br2 = new BufferedReader(new FileReader(file18));
		
		String line1 = "";
		String line2 = "";
		
		ArrayList<String> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		
		while((line1 = br1.readLine()) != null) {
			arr1.add(line1);
		}
		
		while((line2 = br2.readLine()) != null) {
			arr2.add(line2);
		}
		br1.close();
		br2.close();
		
//		for(int i = 0; i < arr1.size(); i++) {
//			System.out.println(arr1.get(i));
//		}
		
		for(int i = 0; i < arr1.size(); i++) {
			for(int j = 0; j < arr2.size(); j++) {
				if(arr1.get(i).contains(arr2.get(j))){
					System.out.print(1.0 + " ");
				}
				else System.out.print(0.0 + " ");
			}
			System.out.println();
		}
		

	}

}
