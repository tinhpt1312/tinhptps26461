#include<stdio.h>
int main(){
	int n, m;
	printf("Xin moi nhap vao so hang cua mang: ");
	scanf("%d", &n);
	printf("Xin moi nhap vao so cot cua mang: ");
	scanf("%d", &m);
	int i,j;
	int mang[n][m];
	for(i=0; i<n; i++){
		for(j=0; j<m; j++){
			printf("Xin moi nhap vao vi tri thi mang[%d][%d]: ", i,j);
			scanf("%d", &mang[i][j]);
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
