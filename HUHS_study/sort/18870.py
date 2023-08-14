#시간초과 문제 해결 -> 리스트 대신 딕셔너리 활용
#list.index(i) 시간복잡도 = O(N)
#index[i] 시간복잡도 = O(1)
import sys

n = int(sys.stdin.readline())
num1 = list(map(int, sys.stdin.readline().split()))
num2 = sorted(set(num1)) #중복값 제거 후 정렬
dic = {} #빈 딕셔너리 생성
for i in range(len(num2)):
    dic[num2[i]] = i #key 값: 숫자, value값 : 인덱스
#print(dic)
for i in num1 :
    print(dic[i], end=' ')