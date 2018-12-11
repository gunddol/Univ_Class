n = 10
m = 1
while m < n:
    tab = n - m
    while tab > 0:
        print('  ',end='')
        tab = tab - 1

    if 1 < m < n-1 :
        cnt = m*2-1
        while cnt > 0:
            if m*2-1 > cnt > 1 :
                print('  ',end='')
            else :
                print('* ',end='')
            cnt = cnt -1
        print()
    else :
        cnt = m*2-1
        while cnt > 0:
            print('* ',end='')
            cnt = cnt -1
        print()
        
    m = m + 1
