#include<stdio.h>
int main(){
	int i, n;
	printf("So phan tu ma ban tao cho Mang la: ");
	scanf("%d", &n);
	int mang[n];
	for(i = 0; i < n; i++){
		printf("Xin moi nhap gia tri cua mang mang[%d]: ", i);
		scanf("%d", &mang[i]);
	}
	float tong, tb;
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
