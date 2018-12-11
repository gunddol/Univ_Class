import random
import time
print("******* START *******")
for i in range(1,5) :
    a = random.randint(1,9)
    b = random.randint(1,9)
    print(str(a) + " * " + str(b) + " = ?")
    time.sleep(3)
    ans = input()
    if int(ans) == a*b :
        print("Correct Answer")
    else :
        print("Wrong Answer, " + str(a) + " * " + str(b) + " = " + str(a*b))

print("******* FINISH *******")
