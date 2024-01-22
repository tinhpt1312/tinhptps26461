#include<stdio.h>
#include<stdlib.h>

int checkYear (int year){
	int flag = 0;
	if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
		flag = 1;
	}
	return flag;
}
int main(){
	int a;
	printf("Nhap nam ban muon kiem tra: ");
	scanf("%d", &a);
	
	if(checkYear(a) == 1){
		printf("%d la nam nhuan", a);
		
	}else{
		printf("%d khong phai nam nhuan", a);
	}
	return 0;
}
