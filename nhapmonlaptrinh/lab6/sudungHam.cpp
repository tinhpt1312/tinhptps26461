#include<stdio.h>
void nhapMang(int a[][100], int n, int m){
	int i,j;
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
			printf("	a[%d][%d] = ", i,j);
			scanf("%d", &a[i][j]);
		}
	}
}
void xuatMang(int a[][100], int n, int m){
	int i,j;
	printf("Xuat mang cac phan tu \n");
	for(i=0; i<n; i++){
		printf("\n");
		for(j=0; j<m; j++){
			printf("	\t%d\t", a[i][j]);
		}
		printf("\n");
		printf("\n");
	}
}
float tongChia(int a[][100], int n, int m){
	float tong = 0;
	float tb;
	int i, j;
	int flag = 0;
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
			if(a[i][j] % 3 == 0){
				tong += a[i][j];
				flag ++;
			}
		}
	}
	tb = tong / flag;
	return tb;
}
int maxMang(int a[][100], int n, int m){
	int max;
	int i, j;
	max = a[0][0];
	for(i = 0; i < n; i++){
		for(j=0; j<m; j++){
		if(max < a[i][j]){
			max = a[i][j];
		}
		}
	}
	return max;
}
/*int binhPhuong(int a[][100], int n, int m){
	int i,j;
	int bp;
	for(i = 0; i<n; i++){
		for(j = 0; j<m ; j++){
			a[i][j] = a[i][j] * a[i][j];
		}
	}
	bp = a[i][j];
	return bp;
}*/
int main(){
	int n, m;
	int a[100][100];
	printf("So hang cua mang la: ");
	scanf("%d", &n);
	printf("So cot cua mang la: ");
	scanf("%d", &m);
	nhapMang(a, n, m);
	xuatMang(a, n, m);
	printf("Gia tri lon nhat trong mang la: %d\n", maxMang(a, n, m));
	printf("Trung binh tong cac so chia het cho 3 trong mang la: %.2f\n", tongChia(a, n, m));
	//printf("Binh phuong cac phan tu trong mang %d", binhPhuong(a, n, m));
	return 0;
}
