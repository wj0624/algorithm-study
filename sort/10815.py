#시간초과
#card list를 set으로 변경 -> 두 숫자 카드에 같은 수 적혀있는 경우 X
#리스트에서의 x in s 연산의 평균 시간 복잡도 : O(n)
#세트에서의 x in s 연산의 평균 시간 복잡도 : O(1)
import sys

n = int(sys.stdin.readline())
card = set(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

for i in num :
    if i in card : print(1, end=' ')
    else : print(0, end=' ')