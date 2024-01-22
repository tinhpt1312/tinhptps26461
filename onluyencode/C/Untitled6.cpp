#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<time.h>
int main()
{
	time_t seconds;
	seconds = time (NULL);
	srand((unsigned) seconds);
	
	
	
	int soBanchon;
	printf("Xin moi nhap vao so ma ban chon (1 --> 15): ");
	scanf("%d", &soBanchon);
	int soNgaunhien = rand() %15 +1;
	printf("So ban chon la : %d\n Quay so %d\n", soBanchon, soNgaunhien);
	
	if(soBanchon == soNgaunhien){
		printf("Chuc mung ban da trung doc dac ");
	}else{
		printf("Chuc ban may man lan sau");
	}
	return 0;
}
