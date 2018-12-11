#include<stdio.h>

int comb(int n, int r){
	if(r == 0 || n == r) return 1;
	else return comb(n-1,r-1) + comb(n-1,r);
}
void main(){
	while(1){
		int n, m;
		scanf("%d %d", &n, &m);
		printf(">> %d\n\n", comb(m,n));
	}
}