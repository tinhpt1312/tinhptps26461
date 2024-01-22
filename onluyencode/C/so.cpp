#include<stdio.h>
void nhapMang(int a[100], int &n){
	int i;
	for(i=0; i<n; i++){
			printf("	a[%d] = ", i);
			scanf("%d", &a[i]);
		}
}
void xuatMang(int a[100], int &n){
	int i;
	printf("Xuat mang cac phan tu \n");
	for(i=0; i<n; i++){
		printf("\n");
			printf("\ta[%d] = %d\t",i ,a[i]);
		}
		printf("\n");
		printf("\n");
}
int ktrant(int &n){
    if(n<2)
        return 0;
    else{
        for(int i=2;i<=n/2;i++)
            if(n%i==0)
                return 0;
        return 1;
    }
}
void soNguyento(int a[100], int &n){
	int i;
	printf("Cac so nguyen to trong mang la: ");
	for(i=1; i<n; i++){
		if(ktrant(a[i])){
			printf("\n\t%d\n", a[i]);
		}
	}
}
void xoa(int mang[], int &n, int viTri){
	for(int i = viTri; i < n; i++){
		mang[i] = mang[i + 1];
	}
	n--;
}
void kiemTra(int a[100], int &n){
	int i;
	int timKiem;
	printf("Nhap gia tri ban muon tim kiem: ");
	scanf("%d", &timKiem);
	int dem = 0;
	int flag;
	for(i=0; i<n; i++){
		if(timKiem == a[i]){
			dem ++;
			flag = i;
		}
	}
	if(dem == 0){
		printf("Khong co gia tri ban muon tim ");
	}else{
		printf("\nTim thay gia tri %d trong mang tai vi tri: a[%d] = %d", timKiem, flag, flag + 1);
	}
	for(i=0; i<n; i++){
		if(a[i] == timKiem){
			xoa(a, n, i);
			i--;
		}
	}
	printf("\n\nMang sau khi xoa K la: ");
	for(i=0; i<n; i++){
		printf("\n\t%d\n",a[i]);
	}
}
int main(){
	int n;
	int a[100];
	printf("So phan tu ban muon co trong mang la: ");
	scanf("%d", &n);
	nhapMang(a, n);
	xuatMang(a, n);
	soNguyento(a, n);
	kiemTra(a, n);
	return 0;
}
