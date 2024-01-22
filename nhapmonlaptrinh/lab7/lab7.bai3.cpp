#include<stdio.h>
#include<string.h>
int main(){
	char chuoi[5][20];
	int i, j;
	char flag[20];
	int size = 5;
	printf("Hay nhap vao 5 chuoi bat ki.\n ");
	for(i = 0; i < size; i++){
		printf("\t");
		gets(chuoi[i]);
	}
	for(i = 0; i < size; i++){
		for(j = 0; j < size; j++){
			if(strcmp(chuoi[j - 1], chuoi[j]) > 0){
				strcpy(flag, chuoi[j - 1]);
				strcpy(chuoi[j - 1], chuoi[j]);
				strcpy(chuoi[j], flag);
			}
		}
	}
	printf("Sap xep phan tu cac chuoi.\n");
	for(i = 0; i < size; i++){
		printf("\t%s\n", chuoi[i]);
	}
	return 0;
}
