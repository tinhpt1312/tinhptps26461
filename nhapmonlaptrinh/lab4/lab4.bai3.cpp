#include<stdio.h>
int main ()
{
	int x,i;
	int check = 0;
	printf("Nhap so ban muon kiem tra :");
	scanf("%d", &x);
	for (i = 1; i<x ; i++){
		if(i*i == x){
			check = 1;
			break;
		}
	}if (check == 0){
		printf("%d khong phai la so chinh phuong", x);
	}else {
		printf("%d la so chinh phuong", x);
	}
	
	return 0;
}
