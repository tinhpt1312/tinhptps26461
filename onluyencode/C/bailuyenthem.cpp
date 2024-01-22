#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
   int i, n;
   int x;
   time_t t;
   char check = 'y';
   do{
   	batdau:
   		
   /* Khoi tao bo sinh so ngau nhien */
   srand((unsigned) time(&t));
   /* in 5 so ngau nhien trong day tu 0 toi 50 */
   for( i = 0 ; i < 1 ; i++ ) 
   {
      x = rand() % 3;
//      printf("%d\n", x);
   }
   int a;
   printf("Ban chon 1. keo/ 2. bua/ 3. la: ");
   scanf("%d", &a);
   do{
   	if(a > 3 || a<0){
   		printf("Vui long chon 1 den 3 tuong ung voi keo, bua, la\n");
   		goto batdau;
	   }else{
	   	break;
	   }
   }while(true);
   	if (a == 1){
	   	if (x == 0){
	   		printf("\tDraw\n");
		   }else if(x == 1){
		   	printf("\tLose\n");
		   }else if(x == 2){
		   	printf("\tWin\n");
		   }
   }else if(a == 2){
	   	if (x == 0){
	   		printf("\tWin\n");
		   }else if(x == 1){
		   	printf("\tDraw\n");
		   }else if(x == 2){
		   	printf("\tLose\n");
		   }
   }else if(a == 3){
	   	if (x == 0){
	   		printf("\tLose\n");
		   }else if(x == 1){
		   	printf("\tWin\n");
		   }else if(x == 2){
		   	printf("\tDraw\n");
		   }
   }
   printf("Ban co muon choi nua khong (Y/N): ");
   fflush(stdin);
   scanf("%s", &check);
   if(check == 'n'){
		printf("Thank kiu. See you again .\n");
		break;
	}
   }while(check == 'y');
   return(0);
}
