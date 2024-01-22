#include<stdio.h>
#include<math.h>
#include<string.h>
#define max 100
int bai1(){
	int n;
	int sum = 0; 
	int giaiThua = 1;
	printf("Nhap so n: ");
	scanf("%d", &n);
	if(n < 0){
		printf("Vui long nhap so duong.");
	} else if(n == 0){
		printf("\nTong cac gia thua la S = 0");
	} else {
		for(int i = 1; i <= n; i++){
		giaiThua *= i;
		sum += giaiThua;
		}
		printf("\nTong cac gia thua tu 1 den %d la: S = %d", n, sum);
	}
	return 0;
}

bool soNguyenTo(int n){
	if (n < 2){
		return false;
	} else {
		for(int i = 2; i <= sqrt(n); i++){
			if(n % i == 0){
				return false;
			}
		}
	}
	return true;
}

void xoaSo(int mang[], int &n, int viTri){
	for(int i = viTri; i < n; i++){
		mang[i] = mang[i + 1];
	}
	n--;
}

void xoaSnt(int mang[], int &n){
	for(int i = 0; i < n; i++){
		if(soNguyenTo(mang[i])){
			xoaSo(mang, n, i);
			i--;
		}
	}
}

int bai2(){
	int n;
	int viTri;
	printf("Nhap so phan tu trong mang: ");
	scanf("%d", &n);
	int mang[n];
	for(int i = 0; i < n; i++){
		printf("Nhap gia tri [%d]: ", i);
		scanf("%d", &mang[i]);
	}
	printf("\nMang da nhap la: ");
	for(int i = 0; i < n; i++){
		printf("\t%d", mang[i]);
	}
	printf("\nCac so nguyen to trong mang la: ");
	for(int i = 0; i < n; i++){
		if(soNguyenTo(mang[i])){
			printf("\t%d", mang[i]);
		}
	}
	printf("\nMang sau khi xoa cac so nguyen to la: ");
	xoaSnt(mang, n);
	for(int i = 0; i < n; i++){
		printf("\t%d", mang[i]);
	}
	return 0;
}

struct sach{
	char maSach[20];
	char tenSach[20];
	int donGia;
};

void nhapSach(sach &x){
	printf("Nhap ma sach: ");
	fflush(stdin);
	gets(x.maSach);
	printf("Nhap ten sach: ");
	fflush(stdin);
	gets(x.tenSach);
	printf("Nhap don gia: ");
	fflush(stdin);
	scanf("%d", &x.donGia);
}

void xuatSach(sach x){
	fflush(stdin);
	printf("%-5s\t%-15s\t%-10d", x.maSach, x.tenSach, x.donGia);
}

int main(){
	int n;
	printf("Nhap so sach can them: ");
	scanf("%d", &n);
	sach a[max];
	fflush(stdin);
	for(int i = 1; i <= n; i++){
		printf("\nNhap quyen sach thu %d\n", i);
		nhapSach(a[i]);
	}
	printf("\nDanh sach quyen sach vua nhap la: \n");
	for(int i = 1; i <= n; i++){
		printf("\n");
		xuatSach(a[i]);
	}
	char check[20];
	int dem = 0;
	printf("\n\nNhap ma sach can tim: ");
	fflush(stdin);
	gets(check);
	for(int i = 0; i < n; i++){
		if(strcmp(a[i].maSach, check) == 0){
			xuatSach(a[i]);
			dem++;
		}
	}
	if(dem == 0){
		printf("\nKhong co ma sach ban can tim.");
	}
	return 0;
}