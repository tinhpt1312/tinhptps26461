#include<stdio.h>
int main(){
	int a, b;
	int i, step;
	int ucln, bcnn;
	printf("Nhap vao a: ");
	scanf("%d", &a);
	printf("Nhap vao b: ");
	scanf("%d", &b);
	for( i=1 ; i<=a || i<=b ; i++){
		if(a % i == 0 && b % i == 0){
			ucln = i;
		}
	}
	if(a > b){
		step = a;	
	}else{
		step = b;
	}
	for(i = step; i <= a*b; i+=step){
		if(i % a == 0 && i % b == 0){
			bcnn = i;
			break;
		}
	}
	printf("BCNN cua %d va %d la %d\n", a, b, bcnn);
	printf("UCLN cua %d va %d la: %d\n", a, b, ucln);
	return 0;
}
