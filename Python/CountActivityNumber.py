import csv
import collections

count_number = collections.Counter()
with open('hmm_heuristic_geneartedData_5000.txt') as input_file:
    r = csv.reader(input_file, delimiter=' ')
    headers = next(r)
    for row in r:
        count_number[row[1]] += 1

print count_number.most_common()