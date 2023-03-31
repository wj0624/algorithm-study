#VPS는 '('와 ')'의 개수가 같아야 함
t = int(input())
for i in range(t):
    #flag = 0
    stack = []
    str = input()
    for j in str:
        if j == '(':
            stack.append(j) #stack에 추가
        elif j == ')':
            if stack: #len(stack)>0
                stack.pop() #stack에 있는 data pop
            else:
                print("NO")#stack에 아무것도 없는 경우 -> ')'가 남았는데 '('이 없다는 뜻
                #flag = 1
                break
    #if not flag :
    else:
        if not stack : #'('와 ')'개수가 동일
            print("YES")
        else:
            print("NO")
#for else문: for문이 정상적으로 끝나면 else문 실행
#참고 사이트: https://shoney.tistory.com/entry/Python-%ED%8C%8C%EC%9D%B4%EC%8D%AC-for-else-%EB%AC%B8-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0