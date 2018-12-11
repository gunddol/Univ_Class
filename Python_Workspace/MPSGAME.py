import random
import time
print("******* START *******")
for i in range(1,5) :
    a = random.randint(1,9)
    b = random.randint(1,9)
    c = random.randint(1,9)
    d = random.randint(1,9)
    print(str(a) + " * " + str(b) + " + " + str(c) + " - " + str(d) + " = ?")
    print("1, ",end='')
    time.sleep(1)
    print("2, ",end='')
    time.sleep(1)
    print("3, ",end='')
    time.sleep(1)
    print(": ",end='')
    ans = input()
    if int(ans) == a*b+c-d :
        print("Correct Answer")
    else :
        print("Wrong Answer, " + str(a) + " * " + str(b) + " + " + str(c) + " - " + str(d) + " = " + str(a*b+c-d))

print("******* FINISH *******")
