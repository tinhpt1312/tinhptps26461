#include<stdio.h>
int main()
{
	float a,b; float x;
	printf(" a =");
	scanf("%f", &a);
	printf(" b =");
	scanf("%f", &b);
	if ( a == 0){
		if ( b == 0){
			printf (" Phuong trinh vo so nghiem");
		}else printf (" Phuong trinh vo nghiem");
	}else{x = -b/(a);
	printf(" Phuong trinh co nghiem x = %.2f", x);
	}
	
	return 0;
}
