#include <stdio.h>
#include<stdlib.h>
int bai1 () 
{
	int min,max;
	float tong = 0;
	float i=0, trungBinh = 0;
	//int so = min;
	printf("Hay nhap gia tri min: ");
    scanf("%d", &min);
	printf("Hay nhap gia tri max: ");
	scanf("%d", &max);
	int so=min;
	while (so <= max){
		if (so %2 == 0){
			tong += so;
			i++;
		}
		so++;
		trungBinh = tong / i;
		
	}printf("Tong cac chia het cho 2 tu %d --> %d la: %.2f\n", min,max,tong);
	printf("Trung binh cong cua cac so chia het cho 2 tu %d --> %d la: %.2f\n\n", min,max,trungBinh);
	return 0;
}

int bai2 ()
{
	int i;
	int n;
	int check = 0;

	
	printf("So ban muon kiem tra :");
	scanf("%d", &n);
	for (i=2;i < n; i++){
		if (n % i == 0){
			check = 1;
			break;
		}
	}
	if (check == 0){
		printf(" %d la so nguyen to\n ", n);
	}else {
		printf(" %d khong phai so nguyen to\n", n);
	}

	return 0;
}

int bai3()
{
	int x,i;
	int check = 0;
	printf("Nhap so ban muon kiem tra :");
	scanf("%d", &x);
	for (i = 1; i<x ; i++){
		if(i*i == x){
			check = 1;//
			break;
		}
	}if (check == 0){
		printf("%d khong phai la so chinh phuong\n", x);
	}else {
		printf("%d la so chinh phuong\n", x);
	}
	
	return 0;
}

int main ()
{
	menu:
		int so;
		do{
		//	printf("\n\n---------------------------------------------------------------\n");
			printf("Bai thuc hanh tuan 4, lab 4 \n");
			printf("\t1. Bai 1: Tinh trung binh tong cac so chia het cho 2\n");
			printf("\t2. Bai 2: Kiem tra so nhap vao la so nguyen to\n");
			printf("\t3. Bai 3: Kiem tra so nhap vao la so chinh phuong\n");
			printf("\t4. Thoat\n");
			printf("\n\n---------------------------------------------------------------\n\n\n");
			
			printf("Hay nap chuong trinh ban muon chay:  ");
			scanf("%d", &so);
			
			
			switch (so){
				case 1:
					bai1();
					break;
				case 2:
					bai2();
					break;
				case 3:
					bai3();
					break;
				case 4:
					printf("Cam on ban da su dung chuong trinh");
					exit(1);
				default:
					printf("Khong hop le, vui long chon 1,2,3,4");
					goto menu;
			}
		}
			while (so);
	return 0;
			
}
