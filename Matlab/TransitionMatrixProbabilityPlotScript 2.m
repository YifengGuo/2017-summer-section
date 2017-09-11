load data;  % load data of two variables
clf;

% set 0 value as NaN
TransitionMatrixProbability(TransitionMatrixProbability == 0) = nan;

% initialize custom colormap
 map = [0.745, 0.745, 0.745
 0.988, 1, 0.38
 0.956, 0.631, 0.3254
 1, 0, 0
 0.537, 0.0352,0.0352         ];

% draw the heatmap with certain parameters
b = heatmap(TransitionMatrixProbability, axis, axis, [], 'TickAngle', 45,...
     'ShowAllTicks', true, 'TickFontSize', 6, 'Colorbar',true, 'Colormap',map);
 
 % set NaN value as white
 set(b,'AlphaData',~isnan(TransitionMatrixProbability));

 % save the plot as pdf format
saveas(gcf,'TransitionMatrixProbability.pdf');
 %print('test','-dmeta','-fillpage')
 
 % save current pig to workspace
 %savefig('TransitionMatrixProbability.fig');