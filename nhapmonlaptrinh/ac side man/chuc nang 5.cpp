#include<stdio.h>

int main(){
	int tienVay;
		menu:
	printf("Nhap vao so tien ban vay: ");
	scanf("%d", &tienVay);
	if(tienVay <= 0){
		printf("Khong hop le vui long nhap lai\n\n");
		goto menu;
	}
	int tienGoc, tienLai;
	int tienTra;
	int tienCon = tienVay;
//	printf(" Ky han  Tien lai phai tra \tTien goc phai tra \tSo tien phai tra \tSo tien con lai\n");
	//	printf("   Ky han | Tien lai phai tra | Tien goc phai tra | So tien phai tra | So tien con lai\n ");
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
	return 0;
}
