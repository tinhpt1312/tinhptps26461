#include<stdio.h>
void nhapMang(int a[100], int n){
	int i;
	for(i=0; i<n; i++){
			printf("	a[%d] = ", i);
			scanf("%d", &a[i]);
		}
}
void xuatMang(int a[100], int n){
	int i;
	printf("Xuat mang cac phan tu \n");
	for(i=0; i<n; i++){
		printf("\n");
			printf("	\t%d\t", a[i]);
		}
		printf("\n");
		printf("\n");
}
void soLe(int a[100], int n){
	int i;
	printf("Cac phan tu le trong mang la: \n");
	for(i=0; i<n; i++){
		if(a[i] % 2 != 0){
			printf("\ta[%d]: %d\n", i, a[i]);
		}
	}
}
void timKiem(int a[100], int n){
	int i;
	int k;
	printf("Gia tri ban muon tim la: ");
	scanf("%d", &k);
	for(i=0; i<n; i++){
		if(k == a[i]){
			printf("Gia tri ban tim kiem la a[%d]: %d", i, a[i]);
		}
	}
}
void sapXep(int a[100], int n){
	int i;
	int j;
	int temp;
	for(i=0; i<n; i++){
		for(j=0; j<n; j++){
			if(a[i] < a[j]){
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
	printf("\nMang sau khi sap xep tang dan la:\n\n");
	for(i=0; i<n; i++){
		printf("vi tri thu a[%d] la: %d\n",i, a[i]);
	}
}
int main(){
	int a[100];
	int i, n;
	printf("So phan tu ban muon nhap trong mang la: ");
	scanf("%d", &n);
	nhapMang(a, n);
	soLe(a, n);
	timKiem(a, n);
	sapXep(a, n);
	return 0;
}
