#include <stdio.h>

int strlen_func(char*);			// strlen
int strcmp_func(char*, char*);	// strcmp
int atoi_func(char);			// atoi (1 digit)

int main(void){
	int length, result;
	char text[20] = "Hanyang University",
		 text2[20] = "Hanyang UniverCity",
		 text3[20] = "Hanyang University",
		 input;
	
	//strlen_func
	length = strlen_func(text);
	printf("string length: %d\n", length);
	
	//strcmp_func
	result = strcmp_func(text, text2);
	printf("string compare: \"%s\" VS \"%s\"\n\t\t%s\n",
			text, text2 , result ? "different" : "equal");
	
	result = strcmp_func(text, text3);
	printf("string compare: \"%s\" VS \"%s\"\n\t\t%s\n",
			text, text3 , result ? "different" : "equal");
	
	//atoi_func
	printf("input character( 0 ~ 9 ) : ");
	scanf("%c", &input);
	result = atoi_func(input);
	printf("atoi result(%%d): %d\n", result);
	
	return 0;
}

int strlen_func(char *text){
	int count = 0;
	while(text[count] != '\0'){
		count++;
	}
	return count;
}

int strcmp_func(char *text, char *text2){
	int count = 0,cnt=0,len1,len2;
	len1 = strlen_func(text);
	len2 = strlen_func(text2);
	if(len1 != len2){
		count = 1;
		return count;
	}
	while(len1 > 0){
		if(text[cnt] != text2[cnt]){
			count = 1;
			break;
		}
		cnt++;
		len1--;
	}
	return count;
}

int atoi_func(char input){
	return (input - '0');
}

