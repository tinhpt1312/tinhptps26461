#include<stdio.h>
int main ()
{
	float Diem;
	printf("Hay nhap diem cua sinh vien\n");
	scanf("%f", &Diem);
	if( Diem <= 10 && Diem >= 9 ){
		printf(" Hoc luc xuat sac\n ");
	}else if ( 9 > Diem && Diem >= 8){
		printf(" Hoc luc gioi\n");
	}else if ( 8 > Diem && Diem >= 6.5){
		printf(" Hoc luc kha");	
	}else if ( 6.5 > Diem && Diem >= 3.5){
		printf(" Hoc luc trung binh");
			}else if ( 3.5 > Diem){
				printf(" Hoc luc yeu");
			}
	
	return 0;
}
