import csv
import numpy as np
import re

with open('B-small-practice.in', newline='') as inputfile:
    data = list(csv.reader(inputfile))

T = data[0][0]
T = int(T)
i = 1

while i <= (2*T):
    N = int(data[i][0])
    P = data[i+1]
    P = P[0].split(' ')
    P = [float(_) for _ in P]
    i += 2
    combinedP = np.zeros((2*N,2*N))
    for j in range(0,2*N-1):
        k = 1
        while j+k < 2*N:
            combinedP[j+k,j] = P[j+k]*P[j]
            k += 1
    onesMatrix = np.tril(np.ones((2*N,2*N)),-1)
    successCombos = onesMatrix - combinedP
    print(successCombos)
