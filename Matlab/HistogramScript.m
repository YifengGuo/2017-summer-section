load('generatedData.mat');
load('originalData.mat');

% x-axis unit interval
edges = [0:2:60];

% initialize histogram for original data
h1 = histogram(originalData, edges, 'Normalization', 'probability');

% set face color for h1
h1.FaceColor = 'red';

% set transparency for h1
h1.FaceAlpha = 1;

% Retain current plot when adding new plots
hold on;

%initialize histogram for generated data
h2 = histogram(generatedData, edges, 'Normalization', 'probability');
h2.FaceColor = 'yellow';
h2.FaceAlpha = 0.5;

% append legend bar
legend('originalData','generatedData')

% show grid lines
grid on;

% The Normalization property specifies 'countdensity'so outlier bin comprising flattening.
h.Normalization = 'countdensity';

mean(originalData)
mean(generatedData)
std(originalData)
std(generatedData)