#Brute Force 설명 : https://hcr3066.tistory.com/26
import sys
n, m = map(int, input().split())
card = list(map(int, sys.stdin.readline().split()))
sum = []
for i in range(n):
    for j in range(i+1,n):
        for k in range(j+1,n):
            if card[i]+card[j]+card[k] > m: #합이 m보다 크면 저장 X
                continue
            else: #합이 m이랑 작거나 같으면 저장
                sum.append(card[i]+card[j]+card[k])
print(max(sum))