import random
rn = ["0", "0", "0"] 
s_cnt = 0 # 스트라이크 갯수
b_cnt = 0 # 볼 갯수 

def reset():
    global rn
    global s_cnt
    global b_cnt
    
    rn[0] = str(random.randint(0, 9))
    rn[1] = rn[0]
    rn[2] = rn[0]
    while (rn[0] == rn[1]):
        rn[1] = str(random.randint(0, 9))
    while (rn[0] == rn[2] or rn[1] == rn[2]):
        rn[2] = str(random.randint(0, 9))

    s_cnt = 0
    b_cnt = 0

def check(num):
    global rn
    global s_cnt
    global b_cnt

    for i in range(0, 3): 
        for j in range(0, 3): 
            if(num[i] == str(rn[j]) and i == j): s_cnt += 1 
            elif(num[i] == str(rn[j]) and i != j): b_cnt += 1 

    if(s_cnt != 3):
        print(str(s_cnt) + " strike, " + str(b_cnt) + " ball." + '\n')
        print("============================")
    return s_cnt

def main() :
    global s_cnt
    global b_cnt
    cnt = 1
    print("S T A R T")
    print("============================"+'\n')
    while(cnt == 1):
        reset()
        while (s_cnt < 3): 
            num = str(input("Guess numbers (000 ~ 999): "+'\n')) 
            s_cnt = 0
            b_cnt = 0
            s_cnt = check(num)
            if(s_cnt == 3): break

        print("YES! The secret number is " + str(num) + "! You have won!" + '\n')
        recycle = str(input("Do you want to play again? (y/n)"))
        if(recycle == "y" or recycle == "Y"): cnt = 1
        else : cnt = 0

    print("Game Finish~ Bye~")
if __name__ == "__main__":
    main()
