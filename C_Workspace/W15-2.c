#include <stdio.h>
 
int largest(int* );
int smallest(int* );
 
int main(void){
 
	int arr[256] = {24, 86, 53, 71, 24, 3, 69, 85};
	printf("The largest number is %d\n", largest(arr));
	printf("The smallest number is %d\n", smallest(arr));
 
	return 0;
}


int largest(int* ptr){
	int m=0;
	while(*ptr){
		if(m < *ptr){
			m = *ptr;
			ptr++;
		}
	}
	return m;
}
 
int smallest(int* ptr){
	int n=9999;
	while(*ptr){
		if(n > *ptr){
			n = *ptr;
			ptr++;
		}
	}
	return n;
}
