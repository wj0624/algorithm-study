import sys
n = int(input())
cnt = 1
stack = []
ans = []
for i in range(n):
    num = int(sys.stdin.readline())
    while cnt<=num: #push
        stack.append(cnt)
        ans.append('+')
        #print('+') 바로 프린트하게 되면 수열을 만들 수 없는데도, 그 전까지 수행한 결과를 출력하게 됨
        cnt+=1
    if stack.pop()==num: #pop
        ans.append('-')
        #print('-')
    else:
        print("NO")
        break
else:
    print("\n".join(ans))