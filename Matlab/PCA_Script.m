mixdata = importdata('mix_data.txt');
[coeff_mix,score_mix,latent_mix] = pca(mixdata,'NumComponents',2);
% result_score = xlsread('temp_result_score.xlsx');
%plot(result_score,'.');
% plot(coeff_mix,'.');
% plot(score_ori,'.');
% hold on;
% plot(score_gen,'.');

% col1 = score_mix(:,1);
% col2 = score_mix(:,2);
% 
% corr2(col1,col2);

% ori_matrix = csvread('122OriginSequencesInNumberFormat_0526.csv');
% gen_matrix = csvread('122GeneratedSequencesInNumberFormat_0526.csv');
% 

first_half = mixdata(1:122,1:235);
second_half = mixdata(123:244,1:235);

diff = corr2(first_half,second_half);
minus_value = minus(first_half,second_half);
figure(1);
heatmap(minus_value);
figure(2);
heatmap(first_half);
figure(3);
heatmap(second_half);