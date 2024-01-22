#include <stdio.h>
#include <conio.h>
void swap(int* a, int* b)
{
   int temp;
   temp = *a;
   *a = *b;
   *b = temp;
}

void printArr(int arr[], int N)
{
   int i;
   for (i = 0; i < N; i++)
   {
       printf("%d\t", arr[i]);
   }
}
// Bubble sort
void BubbleSort(int arr[], int N)
{
   int i, j;
   for (i = 0; i < N; i++)
   {
       for (j = N-1; j > i; j--)
       {
           if(arr[j] < arr[j-1])
               swap(&arr[j], &arr[j-1]);
       }
   }
}
void nhap(int a[100], int n){
	int i;
	for(i=0; i<n; i++){
		printf("a[%d] = ", i);
		scanf("%d", &a[i]);
	}
}
int main()
{
	
   int Arr[100];
   int sizeArr;
   printf("Do dai cua mang la: ");
   scanf("%d", &sizeArr);
   nhap(Arr, sizeArr);
   BubbleSort(Arr, sizeArr);
   printArr(Arr, sizeArr);
   getch();
}



