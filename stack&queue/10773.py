from collections import deque
import sys
k = int(input())
stack = deque()
for i in range(k):
    n = int(sys.stdin.readline())
    if n:
        stack.append(n)
    else:
        stack.pop()
print(sum(stack))