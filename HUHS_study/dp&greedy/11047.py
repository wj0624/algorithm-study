import sys

n, k = map(int, sys.stdin.readline().split())
coins = []
ans = 0

for i in range(n): #입력된 동전 coins list에 저장
    coins.append(int(sys.stdin.readline()))
coins.sort(reverse=True) #coins 내림차순 정렬

for i in coins:
    #k를 구성할 수 있는 가장 큰 동전 찾기
    if k >= i:
        ans += k // i #몫을 ans에 저장
        k %= i #나머지는 k에 저장
        if k <= 0: #k가 0이 되면 반복문 탈출
            break

print(ans)