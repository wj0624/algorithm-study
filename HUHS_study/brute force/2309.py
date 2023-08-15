import sys
n = 9
dwarfs = [int(sys.stdin.readline().strip()) for i in range(n)]
dwarfs.sort() #오름차순 정렬
sum_d = sum(dwarfs)
false = []
#진짜 난쟁이 7명을 찾는 것이 아닌 가짜 난쟁이 2명을 찾기
#모든 난쟁이들의 키의 합 - 가짜 난쟁이 2명의 키의 합 = 100
for i in range(n-1):
    for j in range(i+1, n):
        if (dwarfs[i]+dwarfs[j] == sum_d-100):
            false.append([i,j]) #가짜 난쟁이 번호 저장
i, j = false.pop(0) #정답 중 하나 출력
dwarfs.pop(i)
dwarfs.pop(j-1) #i를 pop하고 나면 한칸씩 왼쪽으로 움직이게 되므로 j-1 해줌
print('\n'.join(map(str, dwarfs)))