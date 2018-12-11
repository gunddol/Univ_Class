#include <stdio.h>
#include <stdlib.h>

void clap(int th){
	int i;
	for(i=0;i<th;i++) printf("clap! ");
	printf("\n");
}
void gamestart(int num){
	int i,j,count,cnt,th,m;
	int index[10];
	for(i=1;i<=num;i++){
		count = 0;
		m = i;
		while(m>0){
			index[count++] = m % 10;
			m = m / 10;
		}
		cnt = 0;
		th = 0;
		for(j=0;j<count;j++){
			if(index[j] == 3 || index[j] == 6 || index[j] == 9){
				cnt = 1;
				th++;
			}
		}
		if(cnt != 0) clap(th);
		else printf("%d\n",i);
	}
	
}
int main(){
	int num;
	
	printf("Please input the last number\n");
	scanf("%d",&num);
	printf("--------start--------\n");
	gamestart(num);
	return 0;	
}