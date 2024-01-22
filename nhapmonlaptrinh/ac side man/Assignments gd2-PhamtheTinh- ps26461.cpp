#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int bai1(){
	float n;
	int i;
	int check, flag;
	check = 0;
	flag = 0;
	char check1 = 'y';
	do{
	printf("\nNhap so ban muon kiem tra: ");
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
		printf("\t%.2f la so nguyen\n", n);
		if(flag == 1){
			printf("\t%.2f khong phai so nguyen to\n", n);
		}else{
			printf("\t%.2f la so nguyen to\n", n);
		}
		if(check == 1){
			printf("\t%.2f la so chinh phuong\n", n);
		}else{
			printf("\t%.2f khong phai so chinh phuong\n", n);
		}
	}else{
		printf("\t%.2f khong phai so nguyen\n", n);
	}
	printf("\nBan co muon tiep tuc kiem tra so nguyen khong (y/n) : ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da su dung chuc nang 1.\n");
		break;
	}
	}while(check1 == 'y');
	return 0;
}
int bai2(){
	int a, b;
	int i, step;
	int ucln, bcnn;
	char check1 = 'y';
	do{
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
	printf("\nBan co muon tiep tuc tim BCNN va UCLN khong (y/n): ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da su dung chuc nang 2\n");
		break;
	}
	}while(check1 == 'y');
	return 0;
}
int bai3(){
	int batDau, ketThuc;
	int giaTien, gioHat;
	int check = 0;
	int flag = 0;
	char check1 = 'y';
	do{
	tien:
		printf("Nhap vao gio bat dau hat: ");
		scanf("%d", &batDau);
		printf("Nhap vao gio ket thuc hat: ");
		scanf("%d", &ketThuc);
		if(batDau >= 12 && batDau < 23){
			check = 1;
		}
		if(ketThuc > 12 && ketThuc <= 23){
			flag = 1;
		}
	if(check == 0 || flag == 0){
		printf("\nGio nay quan chua mo cua hoac da dong cua! Vui long nhap lai so gio\n\n ");
		goto tien;
	}
	gioHat = ketThuc - batDau;
	if(gioHat <= 3 ){
		giaTien = gioHat * 50000;
		printf("\nBan da hat %d gio va so tien cua ban la %d ngan dong\n", gioHat, giaTien);
	}
	if(gioHat > 3){
		giaTien = 150000 + ((gioHat - 3) * 50000) - ((gioHat - 3) * 50000)* 0.3;
		printf("\nBan da hat %d gio va so tien cua ban la %d ngan dong\n", gioHat, giaTien);
	}
	if (batDau >= 14 && batDau <= 17 ){
		if(gioHat <= 3){
			giaTien =(gioHat * 50000) - (gioHat * 50000)* 0.1;
			printf("\nVi ban bat dau hat trong khoang tu 14h --> 17h nen ban duoc giam 10 phan tram\n");
			printf("So tien cua ban la %d ngan dong\n", giaTien);
		}
		if(gioHat > 3){
			giaTien = (150000 + ((gioHat - 3) * 50000) - ((gioHat - 3) * 50000)* 0.3) - ((150000 + ((gioHat - 3) * 50000) - ((gioHat - 3) * 50000)* 0.3) * 0.1);
			printf("\nVi ban bat dau hat trong khoang tu 14h --> 17h nen ban duoc giam 10 phan tram\n");
			printf("So tien cua ban la %d ngan dong\n", giaTien);
		}
	}
	printf("\nBan co muon tinh tien Karaoke nua khong (y/n): ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da su dung chuc nang 3.\n");
		break;
	}
	}while(check1 == 'y');
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
	char check1 = 'y';
	do{
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
	printf("\n\nBan co muon tinh tien dien nua khong (y/n): ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da su dung chuc nang 4\n");
		break;
	}
	}while(check1 == 'y');
	return 0;
}
int bai5(){
	int tienVay;
	char check1 = 'y';
	do{
		menu:
		printf("Nhap vao so tien ban vay: ");
		scanf("%d", &tienVay);
		if(tienVay < 0){
			printf("Khong hop le vui long nhap lai\n\n");
			goto menu;
		}
		if(tienVay == 0){
			printf("Hay quay lai khi ban ngheo hon.\n");
			break;
		}
		int tienGoc, tienLai;
		int tienTra;
		int tienCon = tienVay;
		printf("\t%-12s %-20s %-20s %-20s %-20s\n", "Ky han", "Tien lai phai tra", "Tien goc phai tra", "So tien phai tra", "So tien con lai");
		printf("\n");
		int i;
		for( i = 1; i <= 12; i++){
			tienGoc = tienVay / 12;
			tienLai = tienCon * 0.05;
			tienTra = tienGoc + tienLai;
			tienCon = tienCon - tienGoc;
		   	printf("\tThang %-12d %-20d %-20d %-20d %-20d\n", i, tienLai, tienGoc, tienTra, tienCon);
			printf("\n");
		}
		printf("Ban co tinh se vay tien nua khong (y/n) : ");
		fflush(stdin);
		scanf("%s", &check1);
		if(check1 == 'n'){
			printf("	Cam on ban da vay tien cua chung toi .\n");
			break;
		}
	}while(check1 == 'y');
	return 0;
}
struct sinhVien{
	char MaSV[50];
	char TenSV[50];
	char nganhHoc[50];
	float diemTB;
	char hocLuc[50];
};
char sv[50];
int bai6(){
	int i, n, j;
	char check1 = 'y';
	do{
	printf("Nhap thong tin cho sinh vien.\n");
	printf("So sinh vien ban muon luu thong tin la: ");
	scanf("%d", &n);
	struct sinhVien sv[n];
	printf("\n");
	for(i=0; i<n; i++){
		printf("\n\tSinh vien thu %d\n\n", i+1);
		printf("Nhap ma sinh vien: ");
		fflush(stdin);
        gets(sv[i].MaSV);
        printf("Nhap ten sinh vien: ");
        fflush(stdin);
        gets(sv[i].TenSV);
        printf("Nhap nganh hoc: ");
        gets(sv[i].nganhHoc);
        fflush(stdin);
        printf("Nhap diem trung binh: ");
        scanf("%f", &sv[i].diemTB);
        printf("\n");
	}
	struct sinhVien tmp;
    for( i = 0;i < n;++i){
        for( j = i+1; j < n;++j){
            if(sv[i].diemTB < sv[j].diemTB){
                tmp = sv[i];
                sv[i] = sv[j];
                sv[j] = tmp;
            }
        }
    }
    for(i=0; i<n; i++){
    	if(sv[i].diemTB >= 9){
    		strcpy(sv[i].hocLuc, "Hoc luc xuat sac");
		}else{
			if(sv[i].diemTB >= 8 && sv[i].diemTB < 9){
				strcpy(sv[i].hocLuc, "Hoc luc gioi");
			}else{
				if(sv[i].diemTB >= 6.5 && sv[i].diemTB < 8){
					strcpy(sv[i].hocLuc, "Hoc luc kha");
				}else{
					if(sv[i].diemTB >= 5 && sv[i].diemTB < 6.5){
						strcpy(sv[i].hocLuc, "Hoc luc trung binh");
					}else{
						if(sv[i].diemTB < 5){
							strcpy(sv[i].hocLuc, "Hoc luc yeu");
						}
					}
				}
			}
		}
	}
	printf("Danh sach sinh vien la: \n");
	printf("\t%-10s %-20s %-20s %-10s %-20s\n", "MSSV", "Ho ten", "Nganh hoc", "Diem TB", "Hoc luc");
	printf("\n");
	for(i=0; i<n; i++){
		printf("\t%-10s %-20s %-20s %-10.2f %-20s\n", sv[i].MaSV, sv[i].TenSV, sv[i].nganhHoc, sv[i].diemTB, sv[i].hocLuc);
	}
	printf("\nBan co muon kiem tra sinh vien nua khong (y/n) : ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da quan tam den sinh vien cua chung toi .\n");
		break;
	}
	}while(check1 == 'y');
	return 0;
}
int bai7(){
	int tu1, mau1;
	int tu2, mau2;
	int tong1, hieu1, tich1, thuong1;
	int tong2, hieu2, tich2, thuong2;
	char check1 = 'y';
	do{
	printf("\n\tPhan so thu nhat la\n");
	printf("Nhap tu so: ");
	scanf("%d", &tu1);
	printf("Nhap mau so: ");
	scanf("%d", &mau1);
	printf("\n\tPhan so thu hai la\n");
	printf("Nhap tu so: ");
	scanf("%d", &tu2);
	printf("Nhap mau so: ");
	scanf("%d", &mau2);
	printf("\nPhan so thu nhat la: %d/%d\n", tu1, mau1);
	printf("\nPhan so thu hai la: %d/%d\n", tu2, mau2);
	tong1 = tu1*mau2 + tu2*mau1;
	tong2 = mau1*mau2;
	hieu1 = tu1*mau2 - tu2*mau1;
	hieu2 = mau1*mau2; 
	tich1 = tu1 * tu2;
	tich2 = mau1 * mau2;
	thuong1 = tu1 * mau2;
	thuong2 = tu2 * mau1;
	int ucln1, ucln2, ucln3, ucln4;
	int i;
	for( i=1 ; i<=tong1 || i<=tong2 ; i++){
		if(tong1 % i == 0 && tong2 % i == 0){
			ucln1 = i;
		}
	}
	for( i=1 ; i<=hieu1 || i<=hieu2 ; i++){
		if(hieu1 % i == 0 && hieu2 % i == 0){
			ucln2 = i;
		}
	}
	for( i=1 ; i<=tich1 || i<=tich2 ; i++){
		if(tich1 % i == 0 && tich2 % i == 0){
			ucln3 = i;
		}
	}
	for( i=1 ; i<=thuong1 || i<=thuong2 ; i++){
		if(thuong1 % i == 0 && thuong2 % i == 0){
			ucln4 = i;
		}
	}
	tong1 = tong1 / ucln1; tong2 = tong2 / ucln1;
	hieu1 = hieu1 / ucln2; hieu2 = hieu2 / ucln2;
	tich1 = tich1 / ucln3; tich2 = tich2 / ucln3;
	thuong1 = thuong1 / ucln4; thuong2 = thuong2 / ucln4;
	printf("\n\tTong hai phan so: ");
	printf("%d/%d + %d/%d = %d/%d", tu1, mau1, tu2, mau2, tong1, tong2); 
	printf("\n\n\tHieu hai phan so: ");
	printf("%d/%d - %d/%d = %d/%d", tu1, mau1, tu2, mau2, hieu1, hieu2);
	printf("\n\n\tNhan hai phan so: ");
	printf("%d/%d x %d/%d = %d/%d", tu1, mau1, tu2, mau2, tich1, tich2);
	printf("\n\n\tChia hai phan so: ");
	printf("%d/%d : %d/%d = %d/%d", tu1, mau1, tu2, mau2, thuong1, thuong2);
	printf("\n\nBan co muon tinh toan 2 phan so nua khong (y/n) : ");
	fflush(stdin);
	scanf("%s", &check1);
	if(check1 == 'n'){
		printf("	Cam on ban da su dung chuong trinh cua chung toi .\n");
		break;
	}
	}while(check1 == 'y');
	return 0;
}
int main(){
	int so;
	do{
		menu:
			printf(" \n\n              Assignments giai doan 2\n\n");
			printf("\t0. Thoat.\n");
			printf("\t1. Chuc nang 1: Kiem tra so nguyen.\n");
			printf("\t2. Chuc nang 2: Tinh UCLN va BCNN cua 2 so.\n");
			printf("\t3. Chuc nang 3: Tinh tien hat cho quan Karaoke.\n");
			printf("\t4. Chuc nang 4: Tinh tien dien.\n");
			printf("\t5. Chuc nang 5: Tinh lai suat ngan hang trong 1 nam.\n");
			printf("\t6. Chuc nang 8: Sap xep thong tin sinh vien.\n");
			printf("\t7. Chuc nang 10: Chuong trinh tinh toan phan so.\n");
			printf("Xin moi cac ban chon chuong trinh.\n\n");
			printf("Chuong trinh ban chon la: ");
			scanf("%d", &so);
			switch (so){
				case 0:
					printf("\n\t\tCam on cac ban da su dung chuong trinh.\n");
					exit(1);
				case 1:
					printf("\n\t\tBan da chon chuc nang 1: kiem tra so nguyen.\n\n");
					bai1();
					break;
				case 2:
					printf("\n\t\tBan da chon chuc nang 2: Tim UCLN va BCNN cua hai so.\n\n");
					bai2();
					break;
				case 3:
					printf("\n\t\tBan da chon chuc nang 3: Tinh tien quan Karaoke.\n\n");
					bai3();
					break;
				case 4:
					printf("\n\t\tBan da chon chuc nang 4: Tinh tien dien.\n\n");
					bai4();
					break;
				case 5:
					printf("\n\t\tBan da chon chuc nang 5: Tinh tien lai ngan hang trong 1 nam.\n\n");
					bai5();
					break;
				case 6:
					printf("\n\t\tBan da chon chuc nang 8: Sap xep thong tin sinh vien.\n\n");
					bai6();
					break;
				case 7:
					printf("\n\t\tBan da chon chuc nang 10: Tinh toan 2 phan so.\n\n");
					bai7();
					break;
				default:
					printf("\n\t\tKhong hop le vui long chon lai\n\n");
					goto menu;
			}
	}
	while(so);
	return 0;
}
