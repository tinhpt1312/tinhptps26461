#include<stdio.h>
int main(){
	int batDau, ketThuc;
	int giaTien, gioHat;
	int check = 0;
	int flag = 0;
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
		goto tien;
	}
	gioHat = ketThuc - batDau;
	if(gioHat <= 3 ){
		giaTien = gioHat * 50000;
		printf("Ban da hat %d gio va so tien cua ban la %d ngan dong\n", gioHat, giaTien);
	}
	if(gioHat > 3){
		giaTien = 150000 + ((gioHat - 3) * 50000) - ((gioHat - 3) * 50000)* 0.3;
		printf("Ban da hat %d gio va so tien cua ban la %d ngan dong\n", gioHat, giaTien);
	}
	if (batDau >= 14 && batDau <= 17 ){
		if(gioHat <= 3){
			giaTien =(gioHat * 50000) - (gioHat * 50000)* 0.1;
			printf("Vi ban bat dau hat trong khoang tu 14h --> 17h nen ban duoc giam 10 phan tram\n");
			printf("So tien cua ban la %d ngan dong\n", giaTien);
		}
		if(gioHat > 3){
			giaTien = (150000 + ((gioHat - 3) * 50000) - ((gioHat - 3) * 50000)* 0.3) - ((150000 + ((gioHat - 3) * 50000) - ((gioHat - 3) * 50000)* 0.3) * 0.1);
			printf("Vi ban bat dau hat trong khoang tu 14h --> 17h nen ban duoc giam 10 phan tram\n");
			printf("So tien cua ban la %d ngan dong\n", giaTien);
		}
	}
	return 0;
}


