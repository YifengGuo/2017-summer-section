load data;
lowestValue = 0.00000001;
highestValue = max(TransitionMatrixProbability(:));
TransitionMatrixProbability(TransitionMatrixProbability == 0) = nan;
b = heatmap(TransitionMatrixProbability, axis, axis, [], 'TickAngle', 45,...
     'ShowAllTicks', true, 'TickFontSize', 8, 'Colorbar',true, 'Colormap',map);
% R(isnan(TransitionMatrixProbability(:,:,1))) = 1; %turn NaNs white
% G(isnan(TransitionMatrixProbability(:,:,1))) = 1;
% B(isnan(TransitionMatrixProbability(:,:,1))) = 1;
 map = [0.9, 0.9, 0.9
 1, 1, 0
 0, 1, 0
 0, 0, 1
 1, 0, 0];

%  b = imagesc(TransitionMatrixProbability);
 set(b,'AlphaData',~isnan(TransitionMatrixProbability));
%  
% % cmap = flipud(hot(1024));
% cmap = map;
% colormap(cmap);
% 
% 
% % Make less than lowest value white:
% % cmap(1,:)=[1,1,1];
% colormap(cmap);
% 
% 
% colorbar
