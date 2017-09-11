package SemiSyntheticDataGenerator.fetch_sequential_pattern;

import java.io.IOException;

import SemiSyntheticDataGenerator.cm_spam.*;

public class FetchSequentialPatternByCM_SPAM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputFile = "/Users/guoyifeng/Downloads/getSequentialPattern/122tracesOrigin.csv";
		FormatDataForCM_SPAM fd = new FormatDataForCM_SPAM(inputFile);
		String formattedData = fd.getFormattedDataSet();
		AlgoCMSPAM cmspam = new AlgoCMSPAM();
		String outputFilePath = "formattedData/output1.txt";
		cmspam.setMaxGap(1);
		cmspam.runAlgorithm(formattedData, outputFilePath, 0.1, false);
	}

}
