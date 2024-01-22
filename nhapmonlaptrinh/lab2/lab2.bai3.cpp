#include<stdio.h>
#define Pi 3.14
int main()
{
	float banKinh;
	printf("Ban kinh =");
	scanf("%f", &banKinh);
	float dienTich = banKinh * banKinh * Pi;
	float chuVi = banKinh * 2 * Pi;
	printf("Chu vi hinh tron la %.2f\n", chuVi);
	printf("Dien tich hinh tron la %.2f", dienTich);	
	return 0;
}
