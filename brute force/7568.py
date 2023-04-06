import sys
n = int(input())
people = []
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    people.append([x,y])
for i in range(n):
    rank = 1
    for j in range(n):
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]: #키외 덩치 둘 다 클때만
            rank += 1 #순위 증가
    print(rank, end=' ')