#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
	int a,b,c;

	srand(time(NULL));
	printf("******** Start ********\n");
	while(1){
		a = (rand()%10)+1;
		b = (rand()%10)+1;
		printf("%d * %d = ?\n",a,b);
		scanf("%d",&c);
		if(a*b == c){
			printf("Correct Answer\n");
		}else{
			printf("Wrong Answer, %d * %d = %d\n",a,b,a*b);
		}
	}
	return 0;
}	