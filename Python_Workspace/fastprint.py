import time
start = time.time()
s=''
n = 50
m = n
while m > 0:
    tab = n - m
    while tab > 0:
        s = s + '  '
        tab = tab - 1
    cnt = m*2-1
    while cnt > 0:
        s = s + '* '
        cnt = cnt -1
    s = s + '\n'
    m = m - 1
    
m = 2
while m <= n:
    tab = n - m
    while tab > 0:
        s = s + '  '
        tab = tab - 1
    cnt = m*2-1
    while cnt > 0:
        s = s + '* '
        cnt = cnt -1
    s = s + '\n'
    m = m + 1

print(s)
fin = time.time() - start
print('\n'+'time : ' + str(fin))
