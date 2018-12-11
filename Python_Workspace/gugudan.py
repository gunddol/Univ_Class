print('Input dan.')
num = input()
a=str(num)
print('**********'+num+'dan'+'**********')
count = 1
while count < 10:
    b=str(count)
    c=str(int(num)*int(count))
    print(a+'*'+b+'='+c)
    count = count + 1
print('************************')
