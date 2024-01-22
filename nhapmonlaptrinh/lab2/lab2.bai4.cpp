#include<stdio.h>
int main ()
{
	float diemToan, diemLy, diemHoa;
	printf("Hay nhap diem Toan \n");
	scanf("%f", &diemToan);
	printf("Hay nhap diem Ly \n");
	scanf("%f", &diemLy);
	printf("Hay nhap diem hoa \n");
	scanf("%f", &diemHoa);
	diemToan = diemToan * 3;
	diemLy = diemLy * 2;
	float trungBinh = (diemToan + diemLy + diemHoa)/6;
	printf("Diem trung binh la %.2f", trungBinh);
	return 0;
}
