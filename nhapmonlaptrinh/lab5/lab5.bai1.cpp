#include<stdio.h>
int maxNumber(int num1, int num2, int num3){
    int tmp;
    tmp = num1;
    if (num2 > tmp){
        tmp = num2;}
    if (num3 > tmp){
        tmp = num3;}
    return tmp;}
int main(){
	int a, b, c;
	printf("Nhap so thu nhat: ");
	scanf("%d", &a);
	printf("Nhap so thu hai : ");
	scanf("%d", &b);
	printf("Nhap so thu ba  : ");
	scanf("%d", &c);
	printf("\nMax = %d", maxNumber(a, b, c) );
	return 0;}
