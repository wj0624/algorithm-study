#시간초과
import sys

n = int(sys.stdin.readline())
num1 = list(map(int, sys.stdin.readline().split()))
num2 = sorted(num1)
for i in num1 :
    print(num2.index(i), end=' ')