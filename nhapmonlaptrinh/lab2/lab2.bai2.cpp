#include<stdio.h>
int main()
{
	float chieuDai, chieuRong;
	printf("Chieu dai HCN la\n");
	scanf("%f", &chieuDai);
	printf("Chieu rong HCN la\n");
	scanf("%f", &chieuRong);
	float dienTich = chieuDai * chieuRong;
	printf("Dien tich HCN la %.2f\n", dienTich);
	float chuVi = (chieuDai + chieuRong) * 2;
	printf("Chu vi HCN la %.2f", chuVi);
	return 0;
	
}
