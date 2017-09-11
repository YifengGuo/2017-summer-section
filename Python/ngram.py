'''
writen by DAWEI WANG
6/15/2017 at rutgers
'''
import csv
from datetime import datetime


def read(filename):
    attributes = []
    list_label = []
    with open(filename, 'rU') as csvfile:
        reader = csv.reader(csvfile)
        l_n = 0
        for row in reader:
            if l_n == 0:
                list_label = row
            if l_n != 0:
                attributes.append(row)
            l_n += 1
    return attributes, list_label


def writeNew(filename, data):
    with open(filename, 'wb') as file:
        file.writelines('n = 1\n')
        wr = csv.writer(file, quoting = csv.QUOTE_ALL)
        for row in data:
            wr.writerow(row)


def writeAppend(filename, data, n):
    with open(filename, 'ab') as file:
        file.writelines('\n' + 'n = ' + str(n) + '\n')
        wr = csv.writer(file, quoting = csv.QUOTE_ALL)
        for row in data:
            if row[2][0]>1:
                wr.writerow(row)


def ngram(activity, n):
    dic = {}
    id = []
    n_gram = []
    countN = {}
    count = {}
    result = []
    #collect the activities of a patient
    for row in activity:
        #activity duration
        s1 = row[2]
        s2 = row[3]
        FMT = '%H:%M:%S'
        duration = datetime.strptime(s2, FMT) - datetime.strptime(s1, FMT)
        print (duration)

        if dic.has_key(row[0]):
            list = dic[row[0]]
            list.append(row[1])
            list.append(duration.seconds)
            dic[row[0]]=list
        else:
            id.append(row[0])
            dic[row[0]] = [row[1], duration.seconds]

    # counting
    for num in id:
        str = dic[num]
        #count n_gram
        for i in range(len(str)-n+1):
            act = ''
            for j in range(n):
                if j==0:
                    act += str[i+j]
                else:
                    act = act + ', ' + str[i+j]
            if countN.has_key(act):
                countN[act]=countN[act]+1
            else:
                n_gram.append(act)
                countN[act]=1
        #count n-1_gram
        for i in range(len(str)-n+1):
            act = ''
            for j in range(n-1):
                if j == 0:
                    act += str[i + j]
                else:
                    act = act + ', ' + str[i + j]
            if count.has_key(act):
                count[act]=count[act]+1
            else:
                count[act]=1

    #calculate percentage
    if n>1:
        for ng in n_gram:
            temp = ng.split(', ')
            nu = countN[ng]
            del temp[-1]
            sen = ""
            for i in range(len(temp)):
                if i == 0:
                    sen = temp[0]
                else:
                    sen = sen + ', ' + temp[i]
            de = count[sen]
            p = round(float(nu) / float(de), 3)  # set digits of float equals to 3
            # result.append([p, [ng, countN[ng]], [sen, count[sen]]])
            if p > 0.2:     #set accuracy
                result.append([p, [countN[ng], ng], [count[sen],sen]])
        return result
    elif n==1:
        for ng in n_gram:
            result.append([countN[ng], ng])
        return result
    else:
        raise ValueError('The n should be larger than or equal to 1!')


if __name__ == "__main__":
    activity, label = read('122traces_02.27.17.csv')
    re = ngram(activity, 1)
    re.sort(reverse=True)
    writeNew('output.csv', re)
    for i in range(1000):
        res = ngram(activity, i+2)
        res.sort(reverse=True)
        if (len(res) ==0) or res[-1][0]==1.0 or res[0][2][0]==1:
            break
        writeAppend('output.csv', res, i+2)
