load('hmm_GeneratedTraceLength.mat');
load('hmm_OriginTraceLength.mat');

a1 = max(OriginTraceLength);
a2 = max(GeneratedTraceLength);
% x-axis unit interval and limit
edges = [0:2:300];

% initialize histogram for original data
h1 = histogram(OriginTraceLength, edges, 'Normalization', 'probability');

% set face color for h1
h1.FaceColor = 'red';

% set transparency for h1
h1.FaceAlpha = 1;

% Retain current plot when adding new plots
hold on;

%initialize histogram for generated data
h2 = histogram(GeneratedTraceLength, edges, 'Normalization', 'probability');
h2.FaceColor = 'yellow';
h2.FaceAlpha = 0.5;

% append legend bar
legend('originalData','generatedData','Location','north')

% show grid lines
grid on;

% The Normalization property specifies 'countdensity'so outlier bin comprising flattening.
h.Normalization = 'countdensity';

% Save plot as eps
% saveas(gcf,'Histogram_hmm_TraceLength.pdf');
print('Histogram_hmm_TraceLength','-depsc');

mean(OriginTraceLength)
mean(GeneratedTraceLength)
std(OriginTraceLength)
std(GeneratedTraceLength)