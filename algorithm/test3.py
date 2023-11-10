import sys
input = sys.stdin.readline

N = int(input())
S = list(input().rstrip('\n'))
D, M = map(int, input().split())

score = 0
count = 0
H = 0
Y = 0
U = 0
min = 0

for i in S:
        if(i == 'H'):
            H += 1
            if (count >= 1):
                score += D
                if(count >=2):
                    score += M
            count = 0
        elif(i == 'Y'):
            Y += 1
            if (count >= 1):
                score += D
                if (count >= 2):
                    score += M
            count = 0
        elif(i == 'U'):
            U += 1
            if (count >= 1):
                score += D
                if (count >= 2):
                    score += M
            count = 0
        else:
            count += 1

min = H
if(min > Y):
    min = Y
if(min > U):
    min = U

if(score==0):
    print('Nalmeok')
else:
    print(score)
if(min==0):
    print('I love HanYang University')
else:
    print(min)

