first = input().split()
#첫번째 줄 맨 처음은 N
N = int(first[0])
# 숫자 저장 리스트
num = []
for i in first[1:]:
    num.append(int(i[::-1])) #역순으로 저장

while(N - len(num) != 0):
    l = input().split()
    for i in l :
        num.append(int(i[::-1]))
        
# 정렬한 리스트를 출력
print("\n".join(map(str, sorted(num))))