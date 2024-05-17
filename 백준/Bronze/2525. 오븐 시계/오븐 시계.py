h, m = map(int, input().split())
add = int(input())
h += (m+add)//60
m = (m+add)%60
print(h%24, m)