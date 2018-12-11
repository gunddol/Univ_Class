n = 6
m = 1
while m < n:
    tab = n - m
    while tab > 0:
        print('  ',end='')
        tab = tab - 1
    cnt = m*2-1
    while cnt > 0:
        print('* ',end='')
        cnt = cnt -1
    print()
    m = m + 1
