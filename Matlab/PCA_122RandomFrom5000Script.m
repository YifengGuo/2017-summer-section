mixdata = importdata('mixdata2.txt');
[coeff_mix,score_mix,latent_mix] = pca(mixdata,'NumComponents',2);
figure(4);
plot(score_mix,'.');
saveas(gcf,'score.pdf');

first_half = mixdata(1:122,1:227);
second_half = mixdata(123:244,1:227);

% diff = corr2(first_half,second_half);
minus_value = minus(first_half,second_half);
figure(1);
heatmap(minus_value);
colorbar
saveas(gcf,'diff.pdf');
figure(2);
heatmap(first_half);
colorbar
saveas(gcf,'first_half.pdf');
figure(3);
heatmap(second_half);
colorbar
saveas(gcf,'second_half.pdf');