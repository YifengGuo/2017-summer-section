package SemiSyntheticDataGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class GetActivitiesFromGeneratedData {

	public static void main(String[] args) {
			ArrayList<String> act = null;
			try {
				act = new ArrayList<String>();
				String splitBy = " ";
				BufferedReader br = new BufferedReader(new FileReader("output/geneartedData_6000.txt"));
				String line = "";
				while ((line = br.readLine()) != null) {
					String[] b = line.split(splitBy);
					act.add(b[1].trim());
					// System.out.println(b[1]);
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int Airway_Stated = 0;
			int Breath_Sounds = 0;
			int Distal_Pulses = 0;
			int GCS_Stated = 0;
			int Pupil_Exam = 0;
			int Temperature = 0;
			int Warm_Blanket = 0;
			int Central_Pulses = 0;

			Airway_Stated = Collections.frequency(act, "Airway_Stated");
			Breath_Sounds = Collections.frequency(act, "Breath_Sounds");
			Distal_Pulses = Collections.frequency(act, "Distal_Pulses");
			GCS_Stated = Collections.frequency(act, "GCS_Stated");
			Pupil_Exam = Collections.frequency(act, "Pupil_Exam");
			Temperature = Collections.frequency(act, "Temperature");
			Warm_Blanket = Collections.frequency(act, "Warm_Blanket");
			Central_Pulses = Collections.frequency(act, "Central_Pulses");

			System.out.println("Airway_Stated: " + Airway_Stated);
			System.out.println("Breath_Sounds: " + Breath_Sounds);
			System.out.println("Distal_Pulses: " + Distal_Pulses);
			System.out.println("GCS_Stated: " + GCS_Stated);
			System.out.println("Pupil_Exam: " + Pupil_Exam);
			System.out.println("Temperature: " + Temperature);
			System.out.println("Warm_Blanket: " + Warm_Blanket);
			System.out.println("Central_Pulses: " + Central_Pulses);

			try {
				PrintWriter w = new PrintWriter("output/GeneratedDataActivityFrequency.txt", "UTF-8");
				ArrayList<Integer> freq = new ArrayList<>();
				freq.add(Airway_Stated);
				freq.add(Breath_Sounds);
				freq.add(Distal_Pulses);
				freq.add(GCS_Stated);
				freq.add(Pupil_Exam);
				freq.add(Temperature);
				freq.add(Warm_Blanket);
				freq.add(Central_Pulses);
				for (int i = 0; i < freq.size(); i++) {
					w.println(freq.get(i));
				}
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

