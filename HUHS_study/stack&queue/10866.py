from collections import deque
import sys

def push_front(x):
    deq.appendleft(x)

def push_back(x):
    deq.append(x)

def pop_front():
    return deq.popleft() if deq else -1

def pop_back():
    return deq.pop() if deq else -1

def size():
    return len(deq)

def empty():
    return 0 if deq else 1

def front():
    return deq[0] if deq else  -1

def back():
    return deq[-1] if deq else -1

func = {'push_front':push_front, 'push_back':push_back, 'pop_front':pop_front, 'pop_back':pop_back, 'size':size, 'empty':empty, 'front':front, 'back':back}
n = int(input())
deq = deque()
for i in range(n):
    comm = sys.stdin.readline().strip().split()
    if comm[0]=='push_front' or  comm[0]=='push_back':
        func[comm[0]](int(comm[1]))
    else:
        print(func[comm[0]]())