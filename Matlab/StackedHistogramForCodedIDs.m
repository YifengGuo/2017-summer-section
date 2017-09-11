data = csvread('datasetForCodedIDs.csv');
% columns
Major_Minor_Error = data(:,2);
SYNC = data(:,3);
INSERTED = data(:,4);
SKIPPED = data(:,5);
OutofOrder = data(:,6);

% codedIDs =[20 10 31 7 26 3 19 2 1 6 22 30 4 5 9 17 24 33 29 14 12 35 23 16 37 8 11 13 15 21 32 18 25 27 28 38 34 39 36];

% draw the stacked histogram
figure
h = bar(1:39,[Major_Minor_Error SYNC INSERTED SKIPPED OutofOrder], 0.8, 'stack');

% mycolor
myC= [0 1 0.098
  1 0.9647 0
  0 0.749 1
  1 0 0
  0.4274 0.4274 0.4274];

for k=1:5
  set(h(k),'facecolor',myC(k,:))
end

% title and axis labels
title('Deviations Across All 39 Traces');
xlabel('Coded IDs');
ylabel('Trace Length');

set(gca,'XTick',1:39); % set the number of x labels
% set the content of x labels
set(gca,'XTickLabel',[20 10 31 7 26 3 19 2 1 6 22 30 4 5 9 17 24 33 29 14 12 35 23 16 37 8 11 13 15 21 32 18 25 27 28 38 34 39 36]);

% set the font size of the figure
set(gca, 'fontsize',18);

% rotate the x label ticks 
% set(gca,'XTickLabelRotation',45)

legend('MajorMinorError', 'SYNC', 'INSERTED', 'SKIPPED','OutofOrder')
legend('Location','northwest')



