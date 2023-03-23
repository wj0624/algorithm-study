# map(f, iterable) : 입력 받은 데이터의 각 요소에 함수 f를 적용한 결과를 리턴
#.split() : 문자열 나누기, () 공백 기준
n, k = map(int, input().split()) # n:학생 수, k: 수상자 수
num = list(map(int, input().split()))
num.sort(reverse=True) #내림차순 정렬
print(num[k-1])