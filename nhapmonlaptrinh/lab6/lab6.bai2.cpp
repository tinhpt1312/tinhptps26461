#include<stdio.h>
int main(){
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
