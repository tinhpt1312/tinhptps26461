#include<stdio.h>
#include<string.h>
#include<conio.h>
int main(){
	int i;
	int ch;
	char user[10];
	char pass[10];
	char name[] = "ADMIN";
	char matkhau[] = "12345";
	menu:
		printf("Nhap vao username cua ban: ");
		gets(user);
		printf("Nhap vao password cua ban: ");
		//gets(pass);
		while((ch=getch()) != 13){
			printf("*");
			pass[i] = ch;
			i++;
		}
		if(strcmp(strupr(user), name) == 0 && strcmp(pass, matkhau) == 0 ){
			printf("\n\nDang nhap thanh cong\n");
		} else{
			printf("\n\nDang nhap that bai! Vui long dang nhap lai.\n\n");
			goto menu;
		}
	return 0;
}
