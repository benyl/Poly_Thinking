#include<iostream>
using namespace std;

int fibo(const int &n);

int main(){
	int n;
	while(cin>>n){
		if(n == 0 ) break;
		cout<<fibo(n)<<endl;
	}
	return 0;
}

int fibo(const int &n){
	if(n == 1)return 1;
	if(n == 2)return 2;
	int one = fibo(n-2);
	int two = fibo(n-1);
	return one + two;
}
