#include<stdio.h>
#include<string.h>
#include<time.h>
struct date{
	int tm_mday;
	int tm_mon;
	int tm_year;
};
struct giangVien{
	char maGV[50];
	char tenGV[50];
	date ngaySinh;
};
char gv[50];
int main(){
	int i, n, j;
	printf("Nhap thong tin cho giang vien.\n");
	printf("So giang vien ban muon luu thong tin la: ");
	scanf("%d", &n);
	struct giangVien sv[n];
	printf("\n");
	for(i=0; i<n; i++){
		printf("	Nhap giang vien thu %d\n\n",i+1);
		printf("Nhap ma giang vien: ");
        scanf("%s", &sv[i].maGV);
        printf("\n");
        printf("Nhap ten giang vien: ");
        fflush(stdin);
        gets(sv[i].tenGV);
        printf("\n");
        printf("dd/mm/yy: ");
        scanf("%d%d%d", &sv[i].ngaySinh.tm_mday, &sv[i].ngaySinh.tm_mon, &sv[i].ngaySinh.tm_year);
        fflush(stdin);
        printf("\n");
	}
	printf("Danh sach giang vien la: \n");
	printf("\t%-10s %-10s %-20s %-20s\n", "STT", "MSGV", "Ho ten", "Ngay sinh");
	for(i=0; i<n; i++){
		printf("\t%-10d %-10s %-20s %-2d/%-2d/%-4d\n", i+1, sv[i].maGV, sv[i].tenGV, sv[i].ngaySinh.tm_mday, sv[i].ngaySinh.tm_mon, sv[i].ngaySinh.tm_year);
	}
	char timKiem[50];
		fflush(stdin);
		printf("\nNhap MSSV cua sinh vien ban muon tim vao: ");
		fflush(stdin);
		scanf("%s", &timKiem);
		int dem = 0;
		for(i=0; i<n; i++){
			if(strcmp(sv[i].maGV, timKiem) == 0){
				dem ++;
			printf("\t%-10s %-10s %-20s %-20s\n", "STT", "MSGV", "Ho ten", "Ngay sinh");
			printf("\t%-10d %-10s %-20s %-2d/%-2d/%-4d\n", i+1, sv[i].maGV, sv[i].tenGV, sv[i].ngaySinh.tm_mday, sv[i].ngaySinh.tm_mon, sv[i].ngaySinh.tm_year);
			}
		}
		if(dem == 0){
			printf("Khong co giang vien ban can tim\n");
		}
	return 0;
}
