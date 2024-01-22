#include<stdio.h>
#include<math.h>
int main(){
	float n;
	int i;
	int check, flag;
	check = 0;
	flag = 0;
	printf("Nhap so ban muon kiem tra: ");
	scanf("%f", &n);
	for(i = 2; i < n; i++){
		if(i*i == n){
			check = 1;
		}
		if((int)n % i == 0){
			flag = 1;
		}
	}
	
	if(n == int(n)){
		printf("%.2f la so nguyen\n", n);
		if(flag == 1){
			printf("%.2f khong phai so nguyen to\n", n);
		}else{
			printf("%.2f la so nguyen to\n", n);
		}
		if(check == 1){
			printf("%.2f la so chinh phuong\n", n);
		}else{
			printf("%.2f khong phai so chinh phuong\n", n);
		}
	}else{
		printf("%.2f khong phai so nguyen\n", n);
	}
	return 0;
}
