#include<stdio.h>
#include<string.h>
struct sinhVien{
	char MaSV[50];
	char TenSV[50];
	char nganhHoc[50];
	float diemTB;
};
char sv[50];
int main(){
	int i, n;
	printf("Nhap thong tin cho sinh vien.\n");
	printf("So sinh vien ban muon luu thong tin la: ");
	scanf("%d", &n);
	struct sinhVien sv[n];
	printf("\n");
	for(i=0; i<n; i++){
		printf("	Nhap sinh vien thu %d\n\n",i+1);
		printf("Nhap ma sinh vien: ");
		fflush(stdin);
        scanf("%s", &sv[i].MaSV);
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
	printf("Danh sach sinh vien: \n");
	printf("\t%-10s %-20s %-20s %-7s\n", "MSSV", "Ho Ten", "Nganh Hoc", "Diem TB");
	for(i=0; i<n; i++){
		printf("\t%-10s %-20s %-20s %-7.2f\n", sv[i].MaSV, sv[i].TenSV, sv[i].nganhHoc, sv[i].diemTB);
	}
	return 0;
}
