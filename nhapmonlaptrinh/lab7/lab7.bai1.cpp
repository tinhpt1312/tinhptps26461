#include<string.h>
#include<stdio.h>
int main(){
	char s[100];
	menu:
		printf("Nhap vao chuoi ban muon kiem tra: ");
		gets(s);
		int i = 0;
		int n = 0;
		int p = 0;
			while(s[i++] != '\0'){
				if(s[i] == '1' || s[i] == '2' || s[i] == '3' || s[i] == '4' || s[i] == '5' || s[i] == '6' || s[i] == '7' || s[i] == '8' || s[i] == '9' || s[i] == '0' ){
					printf("Cac con so khong hop le! Vui long nhap vao chu cai\n\n");
					goto menu;
				}else{
				if(s[i] == 'u' || s[i] == 'e' || s[i] == 'o' || s[i] == 'a' || s[i] == 'i' ){
					n++;
				}else
				 if(s[i]!=' '){
					p++;
				}
				
			}
			}
		printf("\nSo ky tu trong chuoi %s la: %d\n", s, strlen(s));
		printf("Chuoi %s co %d nguyen am, va %d phu am", s, n, p);
	return 0;
}
