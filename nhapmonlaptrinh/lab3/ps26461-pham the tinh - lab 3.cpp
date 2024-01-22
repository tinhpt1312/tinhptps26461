

#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int bai1 ()
{
		float Diem;
	printf("Hay nhap diem cua sinh vien ");
	scanf("%f", &Diem);
	if( Diem <= 10 && Diem >= 9 ){
		printf(" Hoc luc xuat sac\n ");
	}else if ( 9 > Diem && Diem >= 8){
		printf(" Hoc luc gioi\n");
	}else if ( 8 > Diem && Diem >= 6.5){
		printf(" Hoc luc kha\n");	
	}else if ( 6.5 > Diem && Diem >= 3.5){
		printf(" Hoc luc trung binh\n");
			}else if ( 3.5 > Diem){
				printf(" Hoc luc yeu\n");
			}
	
	return 0;
}

int bai2 ()
{
	float a,b; float x;
	printf(" a =");
	scanf("%f", &a);
	printf(" b =");
	scanf("%f", &b);
	if ( a == 0){
		if ( b == 0){
			printf (" Phuong trinh vo so nghiem\n");
		}else printf (" Phuong trinh vo nghiem\n");
	}else{x = -b/(a);
	printf(" Phuong trinh co nghiem x = %.2f\n", x);
	}
	
	return 0;
}

int bai3 ()
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
			printf("Phuong trinh co vo so nghiem\n");
		}else{
			if ( b == 0 && c != 0){
				printf("Phuong trinh vo nghiem\n");
			}else{
				if ( b != 0 ){
					x = (-c) / b;
					printf("Phuong trinh co nghiem x= %.2f\n", x);
				}
			}
		}//truong hop a khac 0
	}else{
		d = (b*b) - 4*a*c;
		if (d > 0){
			x1 = (( - b + sqrt (d)) / ( 2 * a));
			x2 = (( - b - sqrt(d)) / ( 2 * a));
			printf ("Phuong trinh co 2 nghiem x1= %.2f , x2= %.2f\n", x1,x2);
		}else{
			if (d == 0){
				x1 = x2 = (-b)/(2*a);
				printf("Phuong trinh co nghiem kep x1 = x2 = %.2f\n", x1);
			}else printf("Phuong trinh vo nghiem\n");
		}
	}
	
	return 0;
	
}

int bai4 ()
{
	float soDien, tienDien;
	float bac1 = 1678;
	float bac2 = 1734;
	float bac3 = 2014;
	float bac4 = 2536;
	float bac5 = 2834;
	float bac6 = 2927;
	//float bac1, bac2, bac3, bac4, bac5, bac6;
	printf(" Hay nhap so dien ban dung thang nay don vi kWh: ");
	scanf("%f", &soDien);
	if (soDien > 0 && soDien <= 50){
		tienDien = soDien * bac1;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 50 && soDien <= 100 ){
		tienDien = 50 * bac1 + (soDien - 50) * bac2 ;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 100 && soDien <= 200){
		tienDien = 50 * bac1 + 50 * bac2 + (soDien - 100) * bac3;
		printf(" Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 200 && soDien <= 300){
		tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + (soDien - 200) * bac4;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 300 && soDien <= 400){
		tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + 100 * bac4 + (soDien - 300) * bac5;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	if (soDien > 400){
		tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + 100 * bac4 + 100 * bac5 + (soDien - 400) * bac6;
		printf("Tien dien thang nay cua ban la: %.2f", tienDien);
	}
	return 0;
}
    
	
int main()
	{
		menu:
	int so;
	do{
	
	printf("\n\nBai thuc hanh tuan 3, Lab 3\n");
	printf("\t1. Bai 1: Chuong trinh tinh hoc luc.\n");
	printf("\t2. Bai 2.1: Chuong trinh tinh phuong trinh bac 1.\n");
	printf("\t3. Bai 2.2: Chuong trinh tinh phuong trinh bac 2.\n");
	printf("\t4. Bai 3: Chuong trinh tinh tien dien theo bac.\n");
	printf("\t5. Thoat.\n\n");
	
	//do{
		//int so;
		printf("Chon chuong trinh ban muon chay\n");
		scanf("%d", &so);
		
		switch (so){
			case 1:
				//printf("Tinh hoc luc cua sinh vien\n");
				bai1();
				break;
			case 2:
				bai2();
				break;
			case 3:
				bai3();
				break;
			case 4:
				bai4();
				break;
			case 5:
				printf("Cam on ban da su dung chuong trinh");
				exit(1);
			default:
				printf("Khong hop le vui long chon lai\n");
				goto menu;
		}
	
	//while(so);	
	}
	while (so);
  return 0;
	}
