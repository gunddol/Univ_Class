op1 = 0
op2 = 0

def result(ans):
    print("result")
    print("------------------")
    print(">>> " + str(ans))
    print("------------------")

def add(a, b) :
    result(float(a+b))
    return float(a+b)

def sub(a, b) :
    result(float(a-b))
    return float(a-b)

def mul(a, b) :
    result(float(a*b))
    return float(a*b)

def div(a, b) :
    result(float(a/b))
    return float(a/b)

def main() :
    global op1
    global op2
    print("firt operand is 0")
    print("operator(+, -, *, /, exit)")
    print(" >> ",end="")

    while(1) :
        op = input()
        if op == '+' : 
            print("operand" + '\n' + " >> ", end="")
            op2 = input()
            op1 = add(float(op1), float(op2))
        elif op == '-' : 
            print("operand" + '\n' + " >> ", end="")
            op2 = input()
            op1 = sub(float(op1), float(op2))
        elif op == '*' : 
            print("operand" + '\n' + " >> ", end="")
            op2 = input()
            op1 = mul(float(op1), float(op2))
        elif op == '/' : 
            print("operand" + '\ln' + " >> ", end="")
            op2 = input()
            op1 = div(float(op1), float(op2))
        elif op == "exit":
            print("계산기를 종료합니다.")
            return
        else:
            print("올바르지 않은 입력입니다.")

        print("operator(+, -, *, /, exit)")
        print(" >> ",end="")

main()
