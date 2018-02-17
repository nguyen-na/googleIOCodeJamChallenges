import csv
import numpy as np
import re
import itertools

with open('B-small-practice.in', newline='') as inputfile:
    data = list(csv.reader(inputfile))

file = open('output.txt','w')

T = data[0][0]
T = int(T)
i = 1
testNum = 1

def all_pairings(actorList):
    if len(actorList) < 2:
        yield actorList
        return
    a = actorList[0]
    for k in range(1,len(actorList)):
        pair = (a,actorList[k])
        for rest in all_pairings(actorList[1:k]+actorList[k+1:]):
            yield [pair] + rest

while i <= (2*T):
    N = int(data[i][0])
    P = data[i+1]
    P = P[0].split(' ')
    P = [float(_) for _ in P]
    combinedP = np.zeros((2*N,2*N))
    for j in range(0,2*N-1):
        k = 1
        while j+k < 2*N:
            combinedP[j+k,j] = P[j+k]*P[j]
            k += 1
    onesMatrix = np.tril(np.ones((2*N,2*N)),-1)
    successCombosP = onesMatrix - combinedP

    allPairings = list(all_pairings(list(range(2*N))))
    lenAllPairings = len(allPairings)
    allShowSuccessP = [1]*lenAllPairings
    j=0
    k=0

    while j < lenAllPairings:
        for k in range(0,N):
            c = allPairings[j][k][0]
            r = allPairings[j][k][1]
            allShowSuccessP[j] *= successCombosP[r,c]
        j +=1
    file.write('Case #' + str(testNum) + ': ' + str(max(allShowSuccessP)) + '\n')
    testNum += 1
    i += 2
file.close()
