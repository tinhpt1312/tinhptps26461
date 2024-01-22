#include <stdio.h>
#include <math.h>
int main ()
{
	float a,b,c;
	float d,x,x1,x2;
	//nhap a b c và xét truong hop a, b = 0
	printf(" a=");
	scanf("%f", &a);
	printf(" b=");
	scanf("%f", &b);
	printf(" c=");
	scanf("%f", &c);
	if ( a == 0 ){
		if ( b == 0 && c == 0){
			printf("Phuong trinh co vo so nghiem");
		}else{
			if ( b == 0 && c != 0){
				printf("Phuong trinh vo nghiem");
			}else{
				if ( b != 0 ){
					x = (-c) / b;
					printf("Phuong trinh co nghiem x= %.2f", x);
				}
			}
		}//truong hop a khac 0
	}else{
		d = (b*b) - 4*a*c;
		if (d > 0){
			x1 = (( - b + sqrt (d)) / ( 2 * a));
			x2 = (( - b - sqrt(d)) / ( 2 * a));
			printf ("Phuong trinh co 2 nghiem x1= %.2f , x2= %.2f", x1,x2);
		}else{
			if (d == 0){
				x1 = x2 = (-b)/(2*a);
				printf("Phuong trinh co nghiem kep x1 = x2 = %.2f", x1);
			}else printf("Phuong trinh vo nghiem");
		}
	}
	
	return 0;
	
}
