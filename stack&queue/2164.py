#시간초과
n = int(input())
card = [x for x in range(1, n+1)]
#0번째를 제일 위
for i in range(n-1):
    card.pop(0)
    card.insert(len(card), card[0])
    card.pop(0)
print(card[0])