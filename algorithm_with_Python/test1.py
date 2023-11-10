import sys

input = sys.stdin.readline
T = int(input())
score = [0] * 5

arr = list(map(int, input().split()))
for i in range(0, T):
    score[i] = arr[i]

ans = 0

if(score[0]>score[2]):
    ans += (abs(score[0]-score[2])*508)
else:
    ans += (abs(score[0]-score[2])*108)
if(score[1]>score[3]):
    ans += (abs(score[1]-score[3])*212)
else:
    ans += (abs(score[1] - score[3])*305)
if(score[4]):
    ans += (score[4]*707)

print(ans*4763)