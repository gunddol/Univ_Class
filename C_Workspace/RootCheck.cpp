#include <stdio.h>

int root_check(int n){
	int i;
	if(n == 1) return 1;
	for(i=1;i<=n/2;i++){
		if(n == i*i) return i;
	}
	return 0;
}

int main(){
	int n=1,m;

	while(n == 1){
		printf("-----------------------------\n");
		printf("Please input the number : ");
		scanf("%d", &n);
		printf("\n");
		m = root_check(n);
		if(m != 0)
			printf("%d is the square number of %d\n\n",n,m);
		else
			printf("%d is not square number.\n\n",n);
		printf("Try again? [yes<1>, no<2>]\n");
		scanf("%d", &n);
	}
	printf("Good Bye~\n");
	printf("-----------------------------\n");
	return 0;
}	