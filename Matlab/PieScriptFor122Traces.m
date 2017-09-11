% open the data file to read data and get the file identifier
fileID1 = fopen('122traces.txt','r');
% define the format of the data to be read
formatSpec = '%d';
% store the read data in a vector B
A = fscanf(fileID1,formatSpec);
% draw the pie chart
pie(A);
% initialize the label name for each area in pie chart
labels = {"L otoscopy-EAR", "Verbal assessment-AA", "Palpation-RUE", "Visual inspection-M", "Visual inspection-N", "L-spine-BK", "Visual inspection-LLE", "Visual inspection-BK", "Visual inspection-RLE", "Visual inspection-G", "Visual inspection-H", "Visual inspection-F", "Visual inspection-C", "Visual inspection-A", "Left pupil-PU", "Pt departure", "L Visual inspection-EAR", "Total Verbalized-GCS", "R otoscopy-EAR", "Palpation-NE", "Palpation-LUE", "Palpation-F", "Visual inspection-LUE", "Rectal-BK", "Log roll-BK", "Palpation-H", "Pt arrival", "Visual assessment-AA", "T-spine-BK", "R visual inspection-EY", "Palpation-LLE", "Visual inspection-RUE", "Palpation-A", "Palpation-C", "Palpation-RLE", "Chest Auscultation-BA", "L DP/PT-PC", "R Visual inspection-EAR", "C-spine-BK", "Stability-PE", "L visual inspection-EY", "Right pupil-PU", "Visual inspection-NE", "R DP/PT-PC"};
% set position and direction of legend bar 
legend(labels,'Location','northeastoutside','Orientation','vertical');