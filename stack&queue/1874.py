import sys
n = int(input())
cnt = 1
flag = 0
stack = []
ans = []
for i in range(n):
    num = int(sys.stdin.readline())
    while cnt<=num:
        stack.append(cnt)
        ans.append('+')
        cnt+=1
    if stack.pop()==num:
        ans.append('-')
    else:
        flag=1
        break
if flag:
    print("NO")
else:
    for i in ans:
        print(i)