#include<stdio.h>
int main ()
{
	int i;
	int n;
	int check = 0;

	
	printf("So ban muon kiem tra :");
	scanf("%d", &n);
	for (i=2;i < n; i++){
		if (n % i == 0){
			check = 1;
			break;
		}
	}
	if (check == 0){
		printf(" %d la so nguyen to\n ", n);
	}else {
		printf(" %d khong phai so nguyen to\n", n);
	}

	return 0;
}
