% open the data file to read data and get the file identifier
fileID1 = fopen('OriginalDataActivityFrequency.txt','r');
% define the format of the data to be read
formatSpec = '%d';
% store the read data in a vector B
A = fscanf(fileID1,formatSpec);
% draw the pie chart
pie(A);
% initialize the label name for each area in pie chart
labels = {'Airway-Stated','Breath-Sounds','Distal-Pulses','GCS-Stated','Pupil-Exam','Temperature','Warm-Blanket','Central-Pulses'};
% set position and direction of legend bar 
legend(labels,'Location','northeastoutside','Orientation','vertical');

