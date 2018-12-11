#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int rn[4],s_cnt,b_cnt;
int num[4];
void reset(){
	srand(time(NULL));
	rn[0] = rand() % 10;
	rn[1] = rn[0];
	rn[2] = rn[0];
    while (rn[0] == rn[1]) rn[1] = rand() % 10;
    while (rn[0] == rn[2] || rn[1] == rn[2]) rn[2] = rand() % 10;

    s_cnt = 0;
    b_cnt = 0;
}

int check(int ball){
	num[0] = ball / 100;
	ball = ball % 100;
	num[1] = ball / 10;
	ball = ball % 10;
	num[2] = ball;

	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			if(num[i] == rn[j] && i == j) s_cnt += 1;
			else if (num[i] == rn[j] && i != j) b_cnt += 1;
		}
	}
	if(s_cnt != 3){
		if(s_cnt == 0 && b_cnt == 0) printf("out!\n");
		else printf("%d strike, %d ball.\n",s_cnt,b_cnt);
        printf("============================\n");
	}
    return s_cnt;
}

int main(){
	int cnt = 1,n;
	char recycle;
    printf("============================\n");
    printf("S T A R T\n");
    while(cnt == 1){
        reset();
		while (s_cnt < 3){
			printf("Guess numbers (000 ~ 999): ");
			scanf("%d",&n);
            s_cnt = 0;
            b_cnt = 0;
            s_cnt = check(n);
            if(s_cnt == 3) break;
		}

		printf("Correct, answer is %d%d%d\n",num[0],num[1],num[2]);
		printf("Play again? <y or n>: ");
		scanf("%s",&recycle);
        if(recycle == 'y' || recycle == 'Y') cnt = 1;
        else cnt = 0;
	}
    printf("Game Finish~ Bye~\n");
	return 0;	
}