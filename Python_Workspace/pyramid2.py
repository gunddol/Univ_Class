import time
start = time.time()
n = 50
m = n
while m > 0:
    tab = n - m
    while tab > 0:
        print('  ',end='')
        tab = tab - 1
    cnt = m*2-1
    while cnt > 0:
        print('* ',end='')
        cnt = cnt -1
    print()
    m = m - 1
    
m = 2
while m <= n:
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

fin = time.time() - start
print('\n'+'time : ' + str(fin))
