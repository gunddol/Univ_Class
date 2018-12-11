import random
import time

rsprsp = ["가위","바위","보"]
bear_hp = [20,10,5]
user_hp = 15
bear_name = ["아빠곰","엄마곰","아기곰"]
item = 0

def battle(a,b,c):
    global user_hp
    global hp
    dam = random.randint(1,7)
    if a == 0:
        if b == 0: print("비겼습니다. 다음 라운드로 넘어갑니다.")
        if b == 1:
            print("졌습니다 ㅠㅠ" + '\n' + bear_name[c] + "이 당신을 공격하여 " + str(dam) + "만큼의 데미지를 입었습니다.")
            user_hp = user_hp - dam
        if b == 2:
            print("이겼습니다!!" + '\n' + bear_name[c] + "을 공격하여 " + str(dam) + "만큼의 데미지를 입혔습니다.")
            hp = hp - dam
    if a == 1:
        if b == 1: print("비겼습니다. 다음 라운드로 넘어갑니다.")
        if b == 2: 
            print("졌습니다 ㅠㅠ" + '\n' + bear_name[c] + "이 당신을 공격하여 " + str(dam) + "만큼의 데미지를 입었습니다.")
            user_hp = user_hp - dam
        if b == 0:
            print("이겼습니다!!" + '\n' + bear_name[c] + "을 공격하여 " + str(dam) + "만큼의 데미지를 입혔습니다.")
            hp = hp - dam
    if a == 2:
        if b == 2: print("비겼습니다. 다음 라운드로 넘어갑니다.")
        if b == 0: 
            print("졌습니다 ㅠㅠ" + '\n' + bear_name[c] + "이 당신을 공격하여 " + str(dam) + "만큼의 데미지를 입었습니다.")
            user_hp = user_hp - dam
        if b == 1:
            print("이겼습니다!!" + '\n' + bear_name[c] + "을 공격하여 " + str(dam) + "만큼의 데미지를 입혔습니다.")
            hp = hp - dam

while(1):
    print("무엇을 하시겠습니까?")
    print("곰을사냥한다(1)/도망친다(2)/체력을 회복한다(3)")
    ch = input()
    if int(ch) == 3:
        if item > 0:
            print("가죽을 몇 개 사용하시겠습니까?")
            print("현재 소유중인 가죽은 " + str(item) + "개 입니다.")
            use = input()
            user_hp = user_hp + int(use)*5
            print("체력이 " + str(int(use)*5) + "만큼 회복되었습니다.")
            item = item - int(use)
        else :
            print("가죽이 부족합니다")
    if int(ch) == 2:
        print("도망쳤습니다")
        print("획득한 가죽은 " + str(item) + "개 입니다")
        break;
    
    if int(ch) == 1:
        if(user_hp > 0) : 
            bear_rand = random.randint(0,2)

            print("어둡고 음침한 밤..." + '\n' + " 당신은" + bear_name[bear_rand] + "를 만납니다!!!")
            hp = bear_hp[bear_rand]
            count = 1
            while(hp > 0):
                print("==========ROUND " + str(count) + "===========")
                print("        HP")
                print("Player  [",end='')
                for i in range(user_hp): print("=",end='')
                print("]")
                print(bear_name[bear_rand] + "   [",end='')
                for i in range(hp): print("=",end='')
                print("]")

                print("가위바위보 중 하나를 선택 하십시오[①가위, ②바위, ③보]",end='')
                rsp = input()
                print('\n',end='')
                rsp = int(rsp) - 1
                rsp_com = random.randint(0,2)

                print("       Player  " + bear_name[bear_rand])
                print("선택    " + str(rsprsp[int(rsp)]) + "    " + str(rsprsp[int(rsp_com)]) + '\n')
                battle(rsp,rsp_com,bear_rand)

                if(user_hp <= 0):
                    print("패배하였습니다.")
                    break
            
                count = count + 1
            if(hp <= 0):
                bear_item = 3 - bear_rand
                print('\n' + "승리!! 곰가죽 " + str(bear_item) + "개를 얻었습니다." + '\n')
                item = item + bear_item
        else :
            print("체력이 없습니다 회복하세요")
        
