package SemiSyntheticDataGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import HMM.DataType.Hmm;
import HMM.IO.Export;
import HMM.Observation.ObservationDiscrete;
import HMM.SDM.Paper.BuildInitialHMM;
import HMM.SDM.Paper.SampleData;
import HMM.SDM.Paper.SampleDataSequences;
import HMM.draw.GenericHmmDrawerDot;
import HMM.toolbox.MarkovGenerator;
import TraceAlignment.ActivityOverFlowException;

public class MarkovModelGenerator_Baseline {
	static public void main(String args[]) throws IOException, CloneNotSupportedException, ActivityOverFlowException {
		/* Input Data */
		SampleDataSequences sampleData = new SampleDataSequences(fileName);
		List<List<ObservationDiscrete<SampleData>>> sequences = sampleData.getSampleDataSequences();
		
		
		
		/* Build Initial HMM */
		BuildInitialHMM iniHMMbuilder = new BuildInitialHMM(sequences);
		iniHmm = iniHMMbuilder.hmm.clone();

		/* Export HMM */
		/* Write Full HMM into file */
		 (new GenericHmmDrawerDot()).write(iniHmm, "Full_" +
				 filename, 0.01, false);
		/* Write simplified HMM into file */
		 (new GenericHmmDrawerDot()).write(iniHmm, filename,
		 0.001, false);
		/* Write Simplified HMM into file */
		 (new GenericHmmDrawerDot()).write(iniHmm, "Simplified_" +
		 filename, printTransitionThreshold, true);
		 (new GenericHmmDrawerDot()).print(iniHmm,
		 printTransitionThreshold);
		 Export export = new Export(iniHmm, "dataForICHI/Intubation");

		/* Calculate Markov Chain NLL */
		 printLogLikelihood(iniHmm, sequences);

		/* Generate Data */
		 List<List<ObservationDiscrete<SampleData>>> generateSeq =
		 generateSequences(iniHmm, sequences, generatedDataNumber);
		
	}

	public MarkovModelGenerator_Baseline(String fileName) {
		this.fileName = fileName;
	}

	public MarkovModelGenerator_Baseline() {
	}


	/************************ configuration parameters ***********************/

	//private static String fileName = "dataForICHI/122traces_secondarySurvey.csv";
	
	/* Dataset 1 */
	//private static String fileName = "dataForICHI/IntubationData_MultipleOccurrence_06.27_noBVMNRB_NameChanged.csv";
	
	/* Dataset 2 */
//	private static String fileName = "dataForICHI/Hospital_Processed_18activities.csv";
	
	/* Dataset 3 */
	//private static String fileName = "dataForICHI/186traces.csv";
	
	/* Dataset temp*/
	  private static String fileName = "output/122traces_02.27.17.csv";
	/* dataset 5. 122 Aim2 data secondary No Visual*/
//	private static String fileName = "dataForICHI/122traces_secondarySurvey_NoVisual.csv";

	
	private static int loop = 1; /*
									 * Loop to run multiple times and reduce
									 * randomness
									 */
	private static double printTransitionThreshold = 0.1;
	private static String filename = "Intubation_" + printTransitionThreshold + ".dot";
	private static int hits = 0; /*
									 * count many traces are same as generated
									 * data
									 */
	private static int generatedDataNumber = 6000;
	private Hmm<ObservationDiscrete<SampleData>> finalmodel;
	private static Hmm<ObservationDiscrete<SampleData>> iniHmm;
	private double lv;

	/************************ configuration parameters ***********************/

	/* Support Functions */
	public static void printLogLikelihood(Hmm<ObservationDiscrete<SampleData>> Hmm,
			List<List<ObservationDiscrete<SampleData>>> sequences) {
		double sum = 0;
		int index = 0;
		for (List<ObservationDiscrete<SampleData>> sequence : sequences) {
			double prob = Hmm.lnProbability(sequence);
//			System.out.println(sequence.size());
//			 System.out.println("sequence " + index + " :" +
//			 prob);
			sum += prob;
			index++;
		}
		System.out.println("sum: " + sum);
		System.out.println("avg.: " + (double) sum / sequences.size());
	}

	/* Data Generator */
	static List<List<ObservationDiscrete<SampleData>>> generateSequences(Hmm<ObservationDiscrete<SampleData>> hmm,
			List<List<ObservationDiscrete<SampleData>>> sequences, int numberGenerated) throws IOException {
		File output = new File("output");
		if(!output.exists()) {
			System.out.println("Creating directory: " + output.getName());
			boolean created = false;// if the file has been created
			try {
				output.mkdir();
				created = true;
			} catch(SecurityException e) {
				e.printStackTrace();
			}
			
			if(created) {
				System.out.println("File " + output.getName() +" created.");
			}
		}
		String output_file = "output/geneartedData" + "_" + numberGenerated;
		BufferedWriter fw = new BufferedWriter(new FileWriter(output_file + ".txt"));

		List<List<ObservationDiscrete<SampleData>>> generatedSequences = new ArrayList<List<ObservationDiscrete<SampleData>>>();
		for (int i = 0; i < numberGenerated; i++) {
			List<ObservationDiscrete<SampleData>> oseq = new MarkovGenerator<ObservationDiscrete<SampleData>>(hmm)
					.observationSequence();
			for (int j = 0; j < oseq.size(); j++) {
				String outputString = i + " " + oseq.get(j);
				fw.append(outputString);
				fw.newLine();
				// System.out.println(i + " " + oseq.get(j));
			}
			generatedSequences.add(oseq);
			 System.out.println(oseq.toString());
			if (sequences.contains(oseq)) {
				hits++;
			}
			  /*print the sequence length for each case */
			// System.out.println(oseq.size());
		}
		fw.close();
		return generatedSequences;
	}


	public Hmm<ObservationDiscrete<SampleData>> get_inimodel() {
		return iniHmm;
	}

}