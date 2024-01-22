#include<stdio.h>
void hoanvi(int *x, int*y)
{
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
	
}

int main(){
	int so1, so2;
	printf("Nhap vao so1: ");
	scanf("%d", &so1);
	printf("Nhap vao so2: ");
	scanf("%d", &so2);
	printf("Gia tri cua so 1 truoc khi hoan vi la %d\n", so1);
	printf("Gia tri cua so 2 truoc khi hoan vi la %d\n", so2);
	hoanvi(&so1, &so2);
	printf("Gia tri cua so 1 sau khi hoan vi la %d\n", so1);
	printf("Gia tri cua so 2 sau khi hoan vi la %d", so2);
	return 0;
}
