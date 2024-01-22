#include<stdio.h>
#include<stdlib.h>
int bai1(){
	int i, n;
	printf("\nSo phan tu ma ban tao cho Mang la: ");
	scanf("%d", &n);
	int mang[n];
	for(i = 0; i < n; i++){
		printf("Xin moi nhap gia tri cua mang mang[%d]: ", i);
		scanf("%d", &mang[i]);
	}
	float  tb;
	float tong = 0;
	int flag = 0;
	for(i = 0; i < n; i++){
		if(mang[i] % 3 == 0){
			tong += mang[i];
			flag ++;
		}
	}
	tb = tong / flag;
	printf("Trung binh tong cac so chia het cho 3 trong mang la: %.2f \n\n" , tb);
	return 0;
}
int bai2(){
	int i,n;
	printf("So phan tu trong mang la: ");
	scanf("%d", &n);
	int mang[n];
	for(i = 0; i < n; i++){
		printf("Xin moi nhap gia tri cho mang[%d]: ", i);
		scanf("%d", &mang[i]);
	}
	int max;
	max = mang[0];
	for(i = 0; i < n; i++){
		if(max < mang[i]){
			max = mang[i];
		}
	}
	int min;
	min = mang[0];
	for(i = 0; i < n; i++){
		if(min > mang[i]){
			min = mang[i];
		}
	}
	printf("Gia tri lon nhat trong mang la: %d\n", max);
	printf("Gia tri nho nhat trong mang la: %d\n", min);
	return 0;
}
int bai3(){
	int n, i;
	printf("So phan tu cua ban trong mang la: ");
	scanf("%d", &n);
	int mang[n];
	for(i=0; i<n; i++){
		printf("Xin moi nhap gia tri cho mang[%d]: ", i);
		scanf("%d", &mang[i]);
	}
	int j;
	int temp;
	for(i=0; i<n; i++){
		for(j=0; j<n; j++){
			if(mang[i] > mang[j]){
				temp = mang[i];
				mang[i] = mang[j];
				mang[j] = temp;
			}
		}
	}
	printf("\nMang sau khi sap xep giam dan la:\n\n");
	for(i=0; i<n; i++){
		printf("vi tri thu mang[%d] la: %d\n",i, mang[i]);
	}
	int k;
	int check;
	for(i=0; i<n; i++){
		for(k=i+1; k<n; k++){
			if(mang[i] > mang[k]){
				check = mang [i];
				mang[i] = mang[k];
				mang[k] = check;
			}
		}
	}
	printf("\nMang sau khi sap xep tang dan la: \n\n");
	for(i=0; i<n; i++){
		printf("Vi tri thu mang[%d] la: %d\n", i, mang[i]);
	}
	return 0;
}
int bai4(){
	int n, m;
	printf("Xin moi nhap vao so hang cua mang: ");
	scanf("%d", &n);
	printf("Xin moi nhap vao so cot cua mang: ");
	scanf("%d", &m);
	int i,j;
	int mang[n][m];
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
			printf("Xin moi nhap vao vi tri cua mang[%d][%d]: ", i,j);
			scanf("%d", &mang[i][j]);
		}
	}
	printf("Xuat mang ma tran co %d hang va %d cot.\n",n,m );
	for(i=0; i<n; i++){
		printf("\n");
		for(j=0; j<m; j++){
			printf("\t%d\t", mang[i][j]);
		}
		printf("\n");
		printf("\n");
	}
	printf("Xuat mang binh phuong cac phan tu \n");
	for(i = 0; i<n; i++){
		for(j = 0; j<m ; j++){
			mang[i][j] = mang[i][j] * mang[i][j];
		}
	}
	for(i=0; i<n; i++){
		printf("\n");
		for(j=0; j<m; j++){
			printf("\t%d\t", mang[i][j]);
		}
		printf("\n");
		printf("\n");
	}
	return 0;
}
int main()
{
	int so;
	do{
		menu:
			printf("\n\tBai thuc hanh tuan 6, Lab 6\n\n");
			printf("\t0. Thoat.\n");
			printf("\t1. Bai 1: Trung binh tong cac so chia het cho 3 trong mang.\n");
			printf("\t2. Bai 2: Gia tri Min, Max trong mang.\n");
			printf("\t3. Bai 3: Sap xep cac gia tri trong mang theo tang dan va giam dan.\n");
			printf("\t4. Bai 4: Binh phuong cac phan tu trong mang.\n\n");
			printf("Moi ban chon chuong trinh: ");
			scanf("%d", &so);
			switch (so){
				case 1:
					printf("\nBan da chon chuong trinh 1.\n");
					bai1();
					break;
				case 2:
					printf("\nBan da chon chuong trinh 2.\n");
					bai2();
					break;
				case 3:
					printf("\nBan da chon chuong trinh 3.\n");
					bai3();
					break;	
				case 4:
					printf("\nBan da chon chuong trinh 4.\n");
					bai4();
					break;
				case 0:
					printf("\n\tCam on ban da su dung chuong trinh.\n");
					exit(1);
				default :
					printf("\tKHONG HOP LE VUI LONG CHON LAI!\n");
					goto menu;
	}
	}
	while(so);
	return 0;
}
