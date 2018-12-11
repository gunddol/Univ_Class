#include<stdio.h>
#include<string.h>

char sp[100];

void atoi_func();

int main(){
	char ch[100];
	int i,cnt;
	while(1){
		cnt=0;
		
		printf("input character(0 ~ 9) : ");
		scanf("%s",ch);
		for(i=0;i<strlen(ch);i++) {
			if(ch[i] > '0'-1 && ch[i] < '9'+1)
				sp[cnt++] = ch[i];
		}
		atoi_func();
	}
	return 0;
}

void atoi_func(){
	int i,s=1,result=0;
	for(i=strlen(sp)-1;i>=0;i--){
		result += (sp[i]-'0')*s;
		sp[i]='\0';
		s *= 10;
	}
	printf("atoi result(%%d): %d\n",result);
}