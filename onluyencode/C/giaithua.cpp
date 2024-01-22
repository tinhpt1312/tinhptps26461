#include<stdio.h>
int main(){
	int n;
	printf("Do dai gia tri ban can tinh la: ");
	scanf("%d", &n);
	int tich=1;
	int tong=0; 
	for(int i=1; i<=n; i++){
		tich = tich * i;
		tong+=tich;
	}
	printf("Tong cac giai thua = %d\n", tong);
	//printf("%d giai thua la = %d", n, tich);
	return 0;
}
