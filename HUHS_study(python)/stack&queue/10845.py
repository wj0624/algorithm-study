import sys

def push(x):
   queue.append(x)

def pop():
    if queue:
        return queue.pop(0)
    else:
        return -1

def size():
    return len(queue)

def empty():
    return 0 if queue else 1

def front():
    return queue[0] if queue else -1

def back():
    return queue[-1] if queue else -1

n = int(sys.stdin.readline())
queue = []
#딕셔너리 이용해 함수 호출
func = {'push':push, 'pop':pop, 'size':size, 'empty':empty, 'front':front, 'back':back}
for i in range(n):
    comm = sys.stdin.readline().strip().split()
    #comm[0]: 명령 저장, comm[1]: 인수
    if comm[0] == 'push':
        func[comm[0]](int(comm[1]))
    else:
        print(func[comm[0]]())