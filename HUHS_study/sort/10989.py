#메모리 초과 문제 있었음.
#input 대신 sys.stdin.readline() 사용
#input() 내장 함수는 sys.stdin.readline()과 비교해서 prompt message를 출력하고, 개행 문자를 삭제한 값을 리턴하기 때문에 느림
#sort()함수 대신 계수 정렬 사용

import sys
n = int(sys.stdin.readline())
num = [0]*10001 #n <= 10000
for i in range(n):
    a = int(sys.stdin.readline())
    num[a] += 1

for i in range(10001):
    if num[i] != 0:
        for j in range(num[i]):
            print(i)