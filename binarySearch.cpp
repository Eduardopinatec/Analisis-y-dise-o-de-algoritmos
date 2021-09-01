#include <iostream>

using namespace std;

int busquedaBinaria(int *a, int inicio, int fin, int buscado){
	if(fin<inicio){
		return -1;
	}
	int medio=(fin+inicio)/2;
	if(buscado==a[medio]){
		return medio;
	}else if(buscado<a[medio]){
		return busquedaBinaria(a, inicio, medio-1, buscado);
	}else{
		return busquedaBinaria(a, medio+1, fin, buscado);
	}
}

int main(){
	int size=10000;
	int *a=new int[size]();
	for(int i=0; i<size; i++){
		a[i]=i;
	}
	busquedaBinaria(a, 0, size-1, 1000);
	return 0;
}
