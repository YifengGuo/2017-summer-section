myFolder = '/Users/guoyifeng/Downloads/SensorGeneratedLog/'; % Define the working folder
% check the file validation
if ~isdir(myFolder)
  errorMessage = sprintf('Error: The following folder does not exist:\n%s', myFolder);
  uiwait(warndlg(errorMessage));
  return;
end
% define pattern and find all the needed files by RegEx
filePattern = fullfile(myFolder, '*.mat');
matFiles = dir(filePattern);

% initialize files and variables by loop
for k = 1:length(matFiles)
  baseFileName = matFiles(k).name;
  fullFileName = fullfile(myFolder, baseFileName);
  fprintf(1, 'Now reading %s\n', fullFileName);
  matData(k) = load(fullFileName);
end

% enumerate caseid to make titles;
figure_title = {'160439', '160608', '160613', '160614', '160615', '160617', '160620', '160621', '160625', '160626', '160634', '160636', '160724', '160725', '160728', '160729', '160730', '160737', '160739', '160740', '160746', '160748', '160753', '160802', '160804', '160814', '160816', '160818', '160819', '160820', '160822', '160823', '160824', '160830', '160832', '160837', '160846', '160847', '160910', '160911', '160916'};

% plot and save plots to local in loop
for i = 1:length(matFiles)
    figure;
    imagesc(transpose(matData(i).prediction{1,1}));
%     set('gcf','Name','i');
    title(figure_title{1,i});
    set(gca,'fontsize',16);
    print(figure_title{1,i},'-dpng');
end
