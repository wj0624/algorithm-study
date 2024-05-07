from itertools import permutations

N, M = map(int, input().split())
arr = []

for s in permutations(range(1, N+1), M):
    arr.append(' '.join(map(str, s)))
    #arr.append(' '.join(map(str, reversed(s))))

#arr.sort()

print('\n'.join(arr))