import sys

def push(x):
   stack.append(x)

def pop():
    if stack:
        return stack.pop() #return 붙여주지 않으면 None 출력됨
    else:
        return -1

def size():
    return len(stack)

def empty():
    return 0 if stack else 1

def top():
    return stack[-1] if stack else -1

n = int(sys.stdin.readline())
stack = []
#딕셔너리 이용해 함수 호출
func = {'push':push, 'pop':pop, 'size':size, 'empty':empty, 'top':top}
for i in range(n):
    comm = sys.stdin.readline().strip().split()
    #print(comm)
    #comm[0]: 명령 저장, comm[1]: 인수
    if comm[0] == 'push':
        func[comm[0]](int(comm[1]))
    else:
        print(func[comm[0]]())