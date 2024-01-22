#include<stdio.h>

int main()
{
	//bai 1 tinh tong hieu cua a,b
	int a,b;
	int c,d;
	printf("Hay nhap vao gia tri a \n");
	scanf("%d", &a);
	printf("Hay nhap vao gia tri b \n");
	scanf("%d", &b);
	c = a+b;
	d = a-b;
	printf("Tong cua hai so la c= %d\n", c);
	printf("Hieu cua hai so la d= %d\n", d);
	return 0;
}
