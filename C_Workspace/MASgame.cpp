#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int random(){
	int n;

	n = (rand()%10) + 1;
	return n;
}
int main(){
	int a,b,c,d,e;
	
	
	printf("******** Start ********\n");
	while(1){
		srand(time(NULL));
		a = random();b = random();c = random();d = random();
		printf("%d * %d + %d - %d = ?\n",a,b,c,d);
		_sleep(1000);
		printf("1, ");
		_sleep(1000);
		printf("2, ");
		_sleep(1000);
		printf("3 : ");
		
		scanf("%d",&e);

		if(a*b+c-d == e){
			printf("Correct Answer\n");
		}else{
			printf("Wrong Answer, %d * %d + %d - %d = %d\n",a,b,c,d,a*b+c-d);
		}
	}
	return 0;
}	