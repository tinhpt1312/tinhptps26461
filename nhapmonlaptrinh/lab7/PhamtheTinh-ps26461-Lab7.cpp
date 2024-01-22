#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>
int bai1(){
	char s[100];
	start:
		printf("\nNhap vao chuoi ban muon kiem tra: ");
		//scanf("%s", &s);
		fflush(stdin);
		gets(s);
		int i = 0;
		int n = 0;
		int p = 0;
			while(s[i++] != '\0'){
				if(s[i] == '1' || s[i] == '2' || s[i] == '3' || s[i] == '4' || s[i] == '5' || s[i] == '6' || s[i] == '7' || s[i] == '8' || s[i] == '9' || s[i] == '0' ){
					printf("Cac con so khong hop le! Vui long nhap vao chu cai\n\n");
					goto start;
				}else{
				if(s[i] == 'u' || s[i] == 'e' || s[i] == 'o' || s[i] == 'a' || s[i] == 'i' ){
					n++;
				}else
				if(s[i] !=' '){
					p++;
				}
			}
			}
		printf("\nSo ky tu trong chuoi %s la: %d\n", s, strlen(s));
		printf("Chuoi %s co %d nguyen am, va %d phu am", s, n, p);
	return 0;
}
int bai2(){
	int i;
	int ch;
	char user[10];
	char pass[10];
	char name[] = "ADMIN";
	char matkhau[] = "12345";
	menu:
		printf("Nhap vao username cua ban: ");
		scanf("%s", &user);
		printf("Nhap vao password cua ban: ");
		scanf("%s", &pass);
		/*while((ch=getch()) != 13){
			printf("*");
			pass[i] = ch;
			i++;
		}*/
		if(strcmp(strupr(user), name) == 0 && strcmp(pass, matkhau) == 0 ){
			printf("\nDang nhap thanh cong\n");
		} else{
			printf("\nDang nhap that bai! Vui long dang nhap lai.\n");
			goto menu;
		}
	return 0;
}
int bai3(){
	char chuoi[5][20];
	int i, j;
	char flag[20];
	int size = 5;
	printf("Hay nhap vao 5 chuoi bat ki.\n ");
	for(i = 0; i < size; i++){
		printf("\t");
		fflush(stdin);
		//scanf("%s", &chuoi[i]);
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
int main(){
	int so;
	do{
		menu:
			printf("	\n\nBai thuc hanh tuan 7, Lab 7\n\n");
			printf("\t1. Bai 1: Kiem tra nguyen am, phu am.\n");
			printf("\t2. Bai 2: Dang nhap tai khoan admin.\n");
			printf("\t3. Bai 3: Sap xep cac chuoi.\n");
			printf("\t4. Thoat\n\n");
			printf("Nhap chuong trinh ban muon chay: ");
			scanf("%d", &so);
			switch (so){
				case 1:
					printf("\t\nBan da chon chuong trinh 1.\n\n");
					bai1();
					break;
				case 2:
					printf("\t\nBan da chon chuong trinh 2.\n\n");
					bai2();
					break;
				case 3:
					printf("\t\nBan da chon chuong trinh 3.\n\n");
					bai3();
					break;
				case 4:
					printf("\n\tCam on ban da su dung chuong trinh cua chung toi.\n");
					exit(1);
				default :
					printf("\tKhong hop le vui long chon lai.\n\n");
					goto menu;
			}
	}while(so);
	return 0;
}
