#include<stdio.h>
int Fibonacci(int n){
	int i;
	int f = 0;
	int f1 = 1;
	int fn;
	printf("\t%d\n", f);
	printf("\t%d\n", f1);
	for(i=2; i<n; i++){
		fn = f1 + f;
		f = f1;
		f1 = fn;
		printf("\t%d\n", fn);
	}
	//return fn;
}
int main(){
	int n;
	printf("Day Fibonacci \n");
	printf("Nhap n: ");
	scanf("%d", &n);
	Fibonacci(n);
	//printf("\t%d\n", Fibonacci(n));
	return 0;
}
