#include<stdio.h>
int main()
{
	int min,max;
	float tong = 0;
	float i=0, trungBinh = 0;
	//int so = min;
	printf("Hay nhap gia tri min: ");
    scanf("%d", &min);
	printf("Hay nhap gia tri max: ");
	scanf("%d", &max);
	int so=min;
	while (so <= max){
		if (so %2 == 0){
			tong += so;
			i++;
		}
		so++;
		trungBinh = tong / i;
		
	}printf("Tong cac chia het cho 2 tu %d --> %d la: %.2f\n", min,max,tong);
	printf("Trung binh cong cua cac so chia het cho 2 tu %d --> %d la: %.2f", min,max,trungBinh);
	return 0;
	
}
