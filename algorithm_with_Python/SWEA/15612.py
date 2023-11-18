T = int(input())

for test_case in range(1, T+1):
    board = [list(input()) for _ in range(8)]
    col = []
    cnt = 0
    check = True

    for i in range(8):
        for j in range(8):
            if board[i][j] == "O" :
                cnt += 1
                if j in col :
                    check = False
                    break
                col.append(j)
        if cnt != i+1 :
            check = False
            break

    if check :
        print(f"#{test_case} yes")
    else :
        print(f"#{test_case} no")