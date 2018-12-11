#include<stdio.h>

int main(){
	int a,b,c;
	printf("A + B - C = ?\n");
	
	printf("Input A: ");
	scanf("%d", &a);
	printf("Input B: ");
	scanf("%d", &b);
	printf("Input C: ");
	scanf("%d", &c);
	
	printf("%d + %d - %d = %d",a,b,c,a+b-c);
	return 0;
}