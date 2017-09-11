load('GeneratedData.mat');
load('OriginalData.mat');

% count = sum(GeneratedData>=10 & GeneratedData<=12);
edges = [0:2:60];
h1 = histogram(OriginalData, edges, 'Normalization', 'probability');
%h1.BinWidth = 2;
% h1.FaceColor = [0 0.5 0.5];
hold on
h2 = histogram(GeneratedData, edges, 'Normalization', 'probability');
%h2.BinWidth = 2;
grid on;
h.Normalization = 'countdensity';

mean(OriginalData)
mean(GeneratedData)
std(OriginalData)
std(GeneratedData)

