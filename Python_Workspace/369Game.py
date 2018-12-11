
def clap(th):
    for j in range(0,th) : print("clap ",end='')
    print()
    
def gamestart(num):
    for i in range(1,num+1):
        index = str(i)
        cnt=0
        th=0
        for j in range(0,len(index)):
            if int(index[j]) == 3 or int(index[j]) == 6 or int(index[j]) == 9:
                cnt = 1
                th += 1
        if(cnt != 0):
            clap(th)
        else :
            print(i)

def main():
    num = input("Please input the last number"+'\n')
    print("--------start--------")
    gamestart(int(num))
    
if __name__ == "__main__":
    main()
