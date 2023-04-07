n = int(input())
six3 = 666
cnt = 0 #몇 번째 작은 종말의 숫자인지 count
while True:
    if '666' in str(six3): #666이 나타나면
        cnt+=1 #cnt++
    if cnt == n: #n번째 종말의 숫자
        print(six3)
        break
    six3 += 1 #666부터 모든 숫자 탐색