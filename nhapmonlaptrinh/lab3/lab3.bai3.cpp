#include<stdio.h>
int main ()
{
	float soDien, tienDien;
	float bac1 = 1678;
	float bac2 = 1734;
	float bac3 = 2014;
	float bac4 = 2536;
	float bac5 = 2834;
	float bac6 = 2927;
	//float bac1, bac2, bac3, bac4, bac5, bac6;
	printf(" Hay nhap so dien ban dung thang nay don vi kWh: ");
	scanf("%f", &soDien);
	if (soDien > 0 && soDien <= 50){
		tienDien = soDien * bac1;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 50 && soDien <= 100 ){
		tienDien = 50 * bac1 + (soDien - 50) * bac2 ;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 100 && soDien <= 200){
		tienDien = 50 * bac1 + 50 * bac2 + (soDien - 100) * bac3;
		printf(" Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 200 && soDien <= 300){
		tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + (soDien - 200) * bac4;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 300 && soDien <= 400){
		tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + 100 * bac4 + (soDien - 300) * bac5;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 400){
		tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + 100 * bac4 + 100 * bac5 + (soDien - 400) * bac6;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	return 0;
}
