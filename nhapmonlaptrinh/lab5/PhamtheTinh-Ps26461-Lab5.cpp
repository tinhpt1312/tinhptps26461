#include<stdio.h>
#include<stdlib.h>
int maxNumber(int num1, int num2, int num3){
    int tmp;
    tmp = num1;
    if (num2 > tmp){
        tmp = num2;}
    if (num3 > tmp){
        tmp = num3;}
    return tmp;}
int bai1(){
	int a, b, c;
	printf("Nhap so thu nhat: ");
	scanf("%d", &a);
	printf("Nhap so thu hai : ");
	scanf("%d", &b);
	printf("Nhap so thu ba  : ");
	scanf("%d", &c);
	printf("\nMax = %d\n\n", maxNumber(a, b, c) );
	return 0;
}
int checkYear (int year){
	int flag = 0;
	if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
		flag = 1;
	}
	return flag;
}
int bai2(){
	int a;
	printf("Nhap nam ban muon kiem tra: ");
	scanf("%d", &a);
	
	if(checkYear(a) == 1){
		printf("%d la nam nhuan\n\n", a);
		
	}else{
		printf("%d khong phai nam nhuan\n\n", a);
	}
	return 0;
}
void hoanvi(int *x, int*y)
{
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
	
}

int bai3(){
	int so1, so2;
	printf("Nhap vao so 1: ");
	scanf("%d", &so1);
	printf("Nhap vao so 2: ");
	scanf("%d", &so2);
	printf("Gia tri cua so 1 truoc khi hoan vi la %d\n", so1);
	printf("Gia tri cua so 2 truoc khi hoan vi la %d\n", so2);
	hoanvi(&so1, &so2);
	printf("Gia tri cua so 1 sau khi hoan vi la %d\n", so1);
	printf("Gia tri cua so 2 sau khi hoan vi la %d\n\n", so2);
	return 0;
}
int main(){
		menu:
	int so;
	
	do{
		
			printf("Bai thuc hanh tuan 5, Lab 5.\n");
			printf("\t1. Bai 1: Ham tim so lon nhat.\n ");
			printf("\t2. Bai 2: Ham tinh nam nhuan.\n");
			printf("\t3. Bai 3: Ham hoan vi.\n");
			printf("\t4. Thoat.\n");
			printf("Moi ban chon chuong trinh:  ");
			scanf("%d", &so);
			switch (so){
				case 1:
					printf("\n\nBan da chon ham tim Max.\n\n");
					bai1();
					break;
				case 2:
				    printf("\n\nBan da chon ham tinh nam nhuan.\n\n");
				    bai2();
					break;
				case 3:
				    printf("\n\nBan da chon ham hoan vi.\n\n");
				    bai3();
					break;
				case 4:
				    printf("\n\nCam on ban da su dung chuong trinh......");
					exit(1);
				default:
				    printf("\n\nKhong hop le vui long chon lai\n\n");
				    goto menu;	
			} 
	}while(so);
	
	return 0;
}
