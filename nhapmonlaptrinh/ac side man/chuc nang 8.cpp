#include<stdio.h>
#include<string.h>
struct sinhVien{
	int MaSV;
	char TenSV[50];
	char nganhHoc[50];
	float diemTB;
	char hocLuc[50];
};
char sv[50];
//typedef sinhVien svien;
int main(){
	int i, n, j;
	printf("Nhap thong tin cho sinh vien.\n");
	printf("So sinh vien ban muon luu thong tin la: ");
	scanf("%d", &n);
	struct sinhVien sv[n];
	printf("\n");
	for(i=0; i<n; i++){
	printf("Nhap ma sinh vien: ");
        scanf("%d", &sv[i].MaSV);
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
    		//printf("Hoc sinh xuat sac\n");
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
		printf("\t%-10d %-20s %-20s %-10.2f %-20s\n", sv[i].MaSV, sv[i].TenSV, sv[i].nganhHoc, sv[i].diemTB, sv[i].hocLuc);
	//	printf("\n");
	}
	return 0;
}
