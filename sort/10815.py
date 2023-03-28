#시간초과
import sys

n = int(sys.stdin.readline())
card = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

for i in num :
    if i in card : print(1, end=' ')
    else : print(0, end=' ')