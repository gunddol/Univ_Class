import random
import time
print("======= 곰 등판 =======")
print("도망?(1) / 싸움(2)")
ch = input()
if(int(ch) == 1):
    ad = random.randint(1,2)
    if ad == 1 :
        print("도망쳤습니다")
    else :
        print("도망에 실패하였습니다")
        print("곰에게 살해당하였습니다")
else:
    print("6번 안에 곰을 물리쳐야 합니다")
    print("공격 시작"+'\n')
    hp = 40
    count = 6
    while count > 0:
        damage = random.randint(1,10)
        bonus = random.randint(1,5)
        print("당신은" + str(damage) + "의 피해를 입혔습니다")
        hp = hp - damage
        if hp > 0:
            print("곰의 남은 체력은 " + str(hp) + "입니다" + '\n')
        else :
            print("곰을 쓰러뜨렸습니다!!")
            break
        if bonus == 3:
            print("BONUS!!공격기회가 1회 늘었습니다" + '\n')
            count = count + 1
        time.sleep(0.5)
        count = count - 1
    if hp > 0:
        print("쥬금")
