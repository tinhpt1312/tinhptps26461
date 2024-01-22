#include<stdio.h>
int UCLN(int &a, int &b){
	int i;
	int ucln;
	for( i=1 ; i<=a || i<=b ; i++){
		if(a % i == 0 && b % i == 0){
			ucln = i;
		}
	}
	return ucln;
}
int main(){
	int tu1, mau1;
	int tu2, mau2;
	int tong1, hieu1, tich1, thuong1;
	int tong2, hieu2, tich2, thuong2;
	char check1 = 'y';
	do{
	printf("\n\tPhan so thu nhat la\n");
	printf("Nhap tu so: ");
	scanf("%d", &tu1);
	printf("Nhap mau so: ");
	scanf("%d", &mau1);
	printf("\n\tPhan so thu hai la\n");
	printf("Nhap tu so: ");
	scanf("%d", &tu2);
	printf("Nhap mau so: ");
	scanf("%d", &mau2);
	printf("\nPhan so thu nhat la: %d/%d\n", tu1, mau1);
	printf("\nPhan so thu hai la: %d/%d\n", tu2, mau2);
	tong1 = tu1*mau2 + tu2*mau1;
	tong2 = mau1*mau2;
	hieu1 = tu1*mau2 - tu2*mau1;
	hieu2 = mau1*mau2; 
	tich1 = tu1 * tu2;
	tich2 = mau1 * mau2;
	thuong1 = tu1 * mau2;
	thuong2 = tu2 * mau1;
	int ucln1, ucln2, ucln3, ucln4;
	int i;
	for( i=1 ; i<=tong1 || i<=tong2 ; i++){
		if(tong1 % i == 0 && tong2 % i == 0){
			ucln1 = i;
		}
	}
	for( i=1 ; i<=hieu1 || i<=hieu2 ; i++){
		if(hieu1 % i == 0 && hieu2 % i == 0){
			ucln2 = i;
		}
	}
	for( i=1 ; i<=tich1 || i<=tich2 ; i++){
		if(tich1 % i == 0 && tich2 % i == 0){
			ucln3 = i;
		}
	}
	for( i=1 ; i<=thuong1 || i<=thuong2 ; i++){
		if(thuong1 % i == 0 && thuong2 % i == 0){
			ucln4 = i;
		}
	}
	tong1 = tong1 / ucln1; tong2 = tong2 / ucln1;
	hieu1 = hieu1 / ucln2; hieu2 = hieu2 / ucln2;
	tich1 = tich1 / ucln3; tich2 = tich2 / ucln3;
	printf("\n\tTong hai phan so: ");
	printf("%d/%d + %d/%d = %d/%d", tu1, mau1, tu2, mau2, tong1, tong2); 
	printf("\n\n\tHieu hai phan so: ");
	printf("%d/%d - %d/%d = %d/%d", tu1, mau1, tu2, mau2, hieu1, hieu2);
	printf("\n\n\tNhan hai phan so: ");
	printf("%d/%d x %d/%d = %d/%d", tu1, mau1, tu2, mau2, tich1, tich2);
	printf("\n\n\tChia hai phan so: ");
	printf("%d/%d : %d/%d = %d/%d", tu1, mau1, tu2, mau2, thuong1, thuong2);
	printf("\n\nBan co muon tinh toan 2 phan so nua khong (y/n) : ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da su dung chuong trinh cua chung toi .\n");
		break;
	}
	}while(check1 == 'y');
	return 0;
}
