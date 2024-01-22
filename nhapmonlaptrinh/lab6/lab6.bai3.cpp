#include<stdio.h>
int main(){
	int n, i;
	printf("So phan tu cua ban trong mang la: ");
	scanf("%d", &n);
	int mang[n];
	for(i=0; i<n; i++){
		printf("Xin moi nhap gia tri cho mang[%d]: ", i);
		scanf("%d", &mang[i]);
	}
	int j;
	int temp;
	for(i=0; i<n; i++){
		for(j=0; j<n; j++){
			if(mang[i] > mang[j]){
				temp = mang[i];
				mang[i] = mang[j];
				mang[j] = temp;
			}
		}
	}
	printf("\nMang sau khi sap xep giam dan la:\n\n");
	for(i=0; i<n; i++){
		printf("vi tri thu mang[%d] la: %d\n",i, mang[i]);
	}
	int k;
	int check;
	for(i=0; i<n; i++){
		for(k=i+1; k<n; k++){
			if(mang[i] > mang[k]){
				check = mang [i];
				mang[i] = mang[k];
				mang[k] = check;
			}
		}
	}
	printf("\nMang sau khi sap xep tang dan la: \n\n");
	for(i=0; i<n; i++){
		printf("Vi tri thu mang[%d] la: %d\n", i, mang[i]);
	}
	return 0;
}
