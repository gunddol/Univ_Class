#include <stdio.h>

float add_func(float, float);
float minus_func(float, float);
float mult_func(float, float);
float div_func(float, float);
float mod_func(float, float);
float exp_func(float, float);

int main(void){
	int cnt=1;
	float op1, op2, result;
	char op;
	
	printf("============================\n");
	printf("operator: +, -, *, /, %, ^\n");
	printf("============================\n");
	
	printf("operand >> ");
	scanf("%f",&op1);	
	while(1){
		if(cnt % 2 == 0){
			printf("operand >> ");
			scanf("%f",&op2);
			cnt++;
			switch(op){
				case '+':
					op1 = add_func(op1,op2);
					break;
				case '-':
					op1 = minus_func(op1,op2);
					break;
				case '*':
					op1 = mult_func(op1,op2);
					break;
				case '/':
					op1 = div_func(op1,op2);
					break;
				case '%':
					op1 = mod_func(op1,op2);
					break;
				case '^':
					op1 = exp_func(op1,op2);
					break;
				default: break;
			}
		}else{
			printf("operator >> ");
			scanf("%c",&op);
			scanf("%c",&op);
			cnt++;
		}
	}
}


float add_func(float a, float b){
	printf("result >> %0.1f\n",a+b);
	return a+b;
}

float minus_func(float a, float b){
	printf("result >> %0.1f\n",a-b);
	return a-b;
}

float mult_func(float a, float b){
	printf("result >> %0.1f\n",a*b);
	return a*b;
}

float div_func(float a, float b){
	printf("result >> %0.1f\n",a/b);
	return a/b;
}

float mod_func(float a, float b){
	while(a > b){
		a -= b;
	}
	printf("result >> %0.1f\n",a);
	return a;
}

float exp_func(float a, float b){
	int i;
	float a1;
	a1 = a;
	for(i=1;i<(int)b;i++) 
		a *= a1;
	printf("result >> %0.1f\n",a);
	return a;
}

