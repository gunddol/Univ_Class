#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define CARDS 52
#define BACK -1 
//추가적인 전역변수 선언 금지
static char card_suit[4][3] = {"♠", "◆", "♥", "♣"};
static char card_num[13][3] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

int deck[CARDS];
int money = 200;

void print_card(int card);
void p_turn_print(int index);
void d_turn_print(int index);
void deckmaking();
int point_calculate(int num);

int main(void){
	int bet,card_index=0,p_bust,d_bust;
	int player_point=0,dealer_point=0;
	char moregame,p_choice;
	
	printf("Are you ready to play the game? (y/n)\n");
	scanf("%c",&moregame);
	
	while(moregame == 'y'){
		if(money <= 0){
			printf("You have no money...Bye...\n");
			break;
		}
		printf("Cash : %d\nHow much do you bet?\n",money);
		while(1){
			scanf("%d",&bet);
			if(money < bet){
				printf("Not Enough money!!\n");
			}else break;
		}
		printf("Bet : %d\n\n",bet);
		money -= bet;
		
		p_bust=0; d_bust=0;
		player_point=0; dealer_point=0; card_index=0;
		deckmaking(); //덱 생성
		
		//시작 카드 두장
		dealer_point += point_calculate(deck[0]) + point_calculate(deck[1]);
		deck[0] *= -1;
		deck[1] *= -1;
		player_point += point_calculate(deck[2]) + point_calculate(deck[3]);
		card_index += 4;
		p_turn_print(card_index);
		
		if(player_point == 21){
			printf("BLACK JACK!!\nPlayer Win!\n\n");
			p_bust=1;
			money += bet + bet + bet/2;
		}

		//플레이어 턴
		while(p_bust == 0){
			//버스트 체크
			if(player_point > 21){
				printf("Player Bust!!\nDelaer Win!\n\n");
				p_bust=1;
				break;
			}
			
			scanf("%c",&p_choice);
			printf("Choose One [h: Hit, s: Stay, d: Double down]\n");
			scanf("%c",&p_choice);
			if(p_choice == 'h'){
				player_point += point_calculate(deck[card_index++]);
				p_turn_print(card_index);			
			}else if(p_choice == 's'){
				break;
			}else if(p_choice == 'd'){
				if(card_index == 4){
					if(money > bet){
						money -= bet;
						bet = bet * 2;
						player_point += point_calculate(deck[card_index++]);
						p_turn_print(card_index);
						break;
					}else printf("You have not enough money!!\n\n");
				}else printf("Cannot choice Double down!!\n\n");
			}
		}
		
		if(player_point > 21 && p_bust == 0){
			printf("Player Bust!!\nDelaer Win!\n\n");
			p_bust=1;
		}

		//딜러 턴
		if(p_bust == 0){
			printf("\nDealer's Turn\n\n");
			while(1){
				d_turn_print(card_index);
				if(dealer_point > 21){
					printf("Dealer Bust!!\nPlayer Win!\n\n");
					money += bet + bet;
					d_bust=1;
					break;
				}
				if(dealer_point > 16) break;
				dealer_point += point_calculate(deck[card_index]);
				deck[card_index] *= -1;
				card_index++;
			}
		}

		if(p_bust == 0 && d_bust == 0){
			player_point = 21 - player_point;
			dealer_point = 21 - dealer_point;
			if(player_point < dealer_point){
				printf("\tPlayer\tDealer\n");
				printf("result\t%d\t%d\n",21 - player_point,21 - dealer_point);
				printf("Player Win!!\n\n");
				money += bet + bet;
			}else if(player_point > dealer_point){
				printf("\tPlayer\tDealer\n");
				printf("result\t%d\t%d\n",21 - player_point,21 - dealer_point);
				printf("Player Lose...\n\n");
			}else{
				printf("\tPlayer\tDealer\n");
				printf("result\t%d\t%d\n",21 - player_point,21 - dealer_point);
				printf("Draw\n\n");
				money += bet;
			}
		}
		printf("Are you ready to play the game? (y/n)\n");
		scanf("%c",&moregame);
		scanf("%c",&moregame);
	}
	
	return 0;
}

void p_turn_print(int index){
	int i;
	
	printf("Dealer :\n");
	print_card(-1);
	print_card(-1 * deck[1]);
	printf("\nPlayer :\n");
	for(i=2;i<index;i++){
		print_card(deck[i]);			
	}
	printf("\n\n");
}

void d_turn_print(int index){
	int i,d=0,p=0;
	for(i=0;i<index;i++){
		if(deck[i] < 0) d++;
		else p++;
	}
	printf("Dealer :\n");
	print_card(-1 * deck[0]);
	print_card(-1 * deck[1]);
	for(i=p+2;i<index;i++){
		print_card(-1 * deck[i]);			
	}
	
	printf("\nPlayer :\n");
	for(i=2;i<2+p;i++){
		print_card(deck[i]);
	}
	printf("\n\n");
}
void print_card(int card){
	if (card == BACK)
		printf("▒▒\t");
	else
		printf("%s%2s\t", card_suit[card/13], card_num[card%13]);
}

void deckmaking(){
	int deck_check[52],card;
	int i,cnt=0;
	
	for(i=0;i<52;i++) deck_check[i] = 1;
	
	srand(time(NULL));
	while(cnt < 52){
		card = rand() % 52;
		if(deck_check[card] == 1) {
			deck[cnt++] = card;
			deck_check[card] = 0;
		}
	}
}

int point_calculate(int num){
	num = num % 13;
	if(num == 0) return 11;
	else if(num > 0 && num < 10) return (num+1);
	else return 10;
}
