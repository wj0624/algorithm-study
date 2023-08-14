import sys
from collections import Counter #Counter : 항목 개수 세기

n = int(sys.stdin.readline())
num = []
for i in range(n):
    num.append(int(sys.stdin.readline()))
num.sort()
print(round(sum(num)/len(num))) #산술평균 : 총합 / 개수
print(num[len(num)//2]) #중앙값 : 오름차순 정렬시 중앙에 위치하는 값
#최빈값 : 가장 많이 등장하는 데이터
mode = Counter(num).most_common() #most_common : 데이터 개수 많은 순으로 정렬된 배열 리턴
if len(mode) > 1 and mode[0][1] == mode[1][1]: # 최빈값이 여러개 -> 2번째로 작은 수 출력
    print(mode[1][0])
else:
    print(mode[0][0])
print(max(num)-min(num)) #범위 : 최대값 - 최소값