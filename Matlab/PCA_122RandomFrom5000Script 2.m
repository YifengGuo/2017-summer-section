mixdata = importdata('mixdata.txt');
[coeff_mix,score_mix,latent_mix] = pca(mixdata,'NumComponents',2);
figure(4);
plot(score_mix,'.');

first_half = mixdata(1:122,1:283);
second_half = mixdata(123:244,1:283);

% diff = corr2(first_half,second_half);
minus_value = minus(first_half,second_half);
figure(1);
heatmap(minus_value);
figure(2);
heatmap(first_half);
figure(3);
heatmap(second_half);