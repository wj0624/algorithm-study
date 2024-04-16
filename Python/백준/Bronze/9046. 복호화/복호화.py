T = int(input())
for i in range(T):
    se = set()
    s = input().replace(" ", "")
    for j in s:
        se.add((j, s.count(j)))
    li = sorted(se, key=lambda x:x[1], reverse=True)
    #print(li)
    if len(li) > 1 :
        if li[0][1] == li[1][1] :
            print("?")
        else:
            print(li[0][0])
    else :
        print(li[0][0])