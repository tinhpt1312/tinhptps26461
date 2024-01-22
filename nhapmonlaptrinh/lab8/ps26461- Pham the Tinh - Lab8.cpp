#include<stdio.h>
#include<string.h>
struct sinhVien{
	char MaSV[50];
	char TenSV[50];
	char nganhHoc[50];
	float diemTB;
};
char sv[50];
//typedef sinhVien svien;
int main(){
	int i, n, j;
	char check1 = 'y';
	printf("Nhap thong tin cho sinh vien.\n");
	printf("So sinh vien ban muon luu thong tin la: ");
	scanf("%d", &n);
	struct sinhVien sv[n];
	printf("\n");
	for(i=0; i<n; i++){
		printf("	Nhap sinh vien thu %d\n\n",i+1);
		printf("Nhap ma sinh vien: ");
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
	printf("Danh sach sinh vien la: \n");
	printf("\t%-10s %-10s %-20s %-20s %-7s\n", "STT", "MSSV", "Ho ten", "Nganh hoc", "Diem TB");
	for(i=0; i<n; i++){
		printf("\t%-10d %-10s %-20s %-20s %-7.2f\n", i+1, sv[i].MaSV, sv[i].TenSV, sv[i].nganhHoc, sv[i].diemTB);
	}
	do{
		char timKiem[50];
		fflush(stdin);
		printf("\nNhap MSSV cua sinh vien ban muon tim vao: ");
		fflush(stdin);
		scanf("%s", &timKiem);
		int dem = 0;
		for(i=0; i<n; i++){
			//if(sv[i].MaSV == timKiem){
			if(strcmp(sv[i].MaSV, timKiem) == 0){
				dem ++;
				printf("\t%-10s %-10s %-20s %-20s %-7s\n","STT" "MSSV", "Ho ten", "Nganh hoc", "Diem TB");
				printf("\t%-10d %-10s %-20s %-20s %-7.2f\n", i+1, sv[i].MaSV, sv[i].TenSV, sv[i].nganhHoc, sv[i].diemTB);
			}
		}
		if(dem == 0){
			printf("Khong co sinh vien ban can tim\n");
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
