#include<stdio.h>
#include<stdlib.h>
#define Pi 3.14

int bai1(){
	
	//bai 1 tinh tong hieu cua a,b
	int a,b;
	int c,d;
	printf("Hay nhap vao gia tri a: ");
	scanf("%d", &a);
	printf("Hay nhap vao gia tri b: ");
	scanf("%d", &b);
	c = a+b;
	d = a-b;
	printf("Tong cua hai so la c= %d\n", c);
	printf("Hieu cua hai so la d= %d\n", d);
	return 0;
}

int bai2(){
		float chieuDai, chieuRong;
	printf("Chieu dai HCN la: ");
	scanf("%f", &chieuDai);
	printf("Chieu rong HCN la: ");
	scanf("%f", &chieuRong);
	float dienTich = chieuDai * chieuRong;
	printf("Dien tich HCN la %.2f\n", dienTich);
	float chuVi = (chieuDai + chieuRong) * 2;
	printf("Chu vi HCN la %.2f", chuVi);
	return 0;
	
}

int bai3(){
	float banKinh;
	printf("Ban kinh =");
	scanf("%f", &banKinh);
	float dienTich = banKinh * banKinh * Pi;
	float chuVi = banKinh * 2 * Pi;
	printf("Chu vi hinh tron la %.2f\n", chuVi);
	printf("Dien tich hinh tron la %.2f", dienTich);	
	return 0;
}

int bai4(){
	float diemToan, diemLy, diemHoa;
	printf("Hay nhap diem Toan: ");
	scanf("%f", &diemToan);
	printf("Hay nhap diem Ly: ");
	scanf("%f", &diemLy);
	printf("Hay nhap diem Hoa: ");
	scanf("%f", &diemHoa);
	diemToan = diemToan * 3;
	diemLy = diemLy * 2;
	float trungBinh = (diemToan + diemLy + diemHoa)/6;
	printf("Diem trung binh la %.2f", trungBinh);
	return 0;
}

int main(){
	
		menu:
			int so;
			do{
				printf("\n\n\nBai thuc hanh tuan 2, lab 2\n");
				printf("\t1. Bai 1: Tong, Hieu cua 2 so tu nhien\n");
				printf("\t2. Bai 2: Chu vi, Dien tich cua HCN\n");
				printf("\t3. Bai 3: Chu vi, Dien tich cua hinh tron\n");
				printf("\t4. Bai 4: Trung binh cong diem Toan, Ly, Hoa\n");
				printf("\t5. Bai 5: Thoat\n\n");
				
				printf("Chon chuong trinh ban muon chay:  ");
				scanf("%d", &so);
				
				switch (so){
					case 1:
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
						printf("Khong hop le vui long chon 1,2,3,4");
						goto menu;
				}
			}
			while(so);
	
	
	
	
	return 0;
}
