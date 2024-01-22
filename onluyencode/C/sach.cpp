#include<stdio.h>
#include<string.h>
struct sach{
	char maSach[50];
	char tenSach[50];
	int donGia;
};
int main(){
	int i, n;
	char check1 = 'y';
	printf("Nhap thong tin cho sach.\n");
	printf("So sach ban muon luu thong tin la: ");
	scanf("%d", &n);
	struct sach s[n];
	printf("\n");
	for(i=0; i<n; i++){
		printf("	Nhap sach thu %d\n\n",i+1);
		printf("Ma sach: ");
        fflush(stdin);
        gets(s[i].maSach);
        printf("\n");
        printf("Ten sach: ");
        fflush(stdin);
        gets(s[i].tenSach);
        printf("\n");
        printf("Don gia: ");
        scanf("%d", &s[i].donGia);
        fflush(stdin);
        printf("\n");
	}
	printf("\t%-10s %-20s %-20s %-20s\n", "STT", "Ma sach", "Ten sach", "Don gia");
	for(i=0; i<n; i++){
		printf("\t%-10d %-20s %-20s %-20d\n", i+1, s[i].maSach, s[i].tenSach, s[i].donGia);
	}
	do{
		char timKiem[50];
		fflush(stdin);
		printf("\nNhap ma sach cua sach ban muon tim vao: ");
		fflush(stdin);
		gets(timKiem);
		int dem = 0;
		for(i=0; i<n; i++){
			if(strcmp(s[i].maSach, timKiem) == 0){
			dem ++;
			printf("\t%-10s %-20s %-20s %-20s\n", "STT", "Ma sach", "Ten sach", "Don gia");
			printf("\t%-10d %-20s %-20s %-20d\n", i+1, s[i].maSach, s[i].tenSach, s[i].donGia);	}
		}
		if(dem == 0){
			printf("Khong co sach ban can tim\n");
		}
		printf("\nBan co muon tim kiem sach nua khong (y/n) : ");
		fflush(stdin);
		scanf("%s", &check1);
		if(check1 == 'n'){
		printf("	Cam on ban da quan tam den sach cua chung toi .\n");
		break;
	}
	}while(check1 == 'y');
	
	return 0;
}
