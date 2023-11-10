n = int(input())
ans = 0
for i in range(1, n+1): #1 부터 n까지 모든 수 분해합 구하기
    num = list(str(i)) #각 자리수 별로 분해해서 숫자를 num 배열에 넣음
    ans = i + sum(map(int, num))
    #i(자기 자신) + sum(map(int, num)(각 자리수의 합, num list에 있는 원소들을 int로 변환 후 총합)
    if ans == n:
        print(i)
        break
else: #모든 수 탐색 완료 -> break 없었으면 생성자 존재 x
    print(0)