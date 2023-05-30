# 제일 싼 가격일 때의 기름으로 이동
n = int(input())
dist = list(map(int, input().split()))
price = list(map(int, input().split()))
ans = 0 #답 저장
x = price[0] #제일 싼 가격으로 갱신
for i in range(n-1):
    if price[i] < x:
        x = price[i]
    ans += x * dist[i] #가격 * 거리
print(ans)