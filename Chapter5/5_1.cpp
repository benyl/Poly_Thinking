/**
 *  Crack Code Interview 5.1
 *  sample input:
 *  n : 1024
 *  m : 21
 *  i : 2
 *  j : 6
 *  output: 1108
 * */

#include<bitset>
#include<iostream>
#include<string.h>
using namespace std;
typedef  unsigned long 	BYTE;
void cal(BYTE m,BYTE n,int i,int j );
int main(){
	BYTE n,m;
	int cmd;
	while(true){
		cout<<endl<<" ?n :"<<endl;
		cin>>n;
		cout<<endl<<" ?m :"<<endl;
		cin>>m;
		
		int i,j;
		cout<<endl<<" ?i :"<<endl;
		cin>>i;
		
		cout<<endl<<" ?j :"<<endl;
		cin>>j;

	    cal(m,n,i,j);

		//exit
		cin>>cmd;
		if(cmd == 0){
			break;
		}
	}
	

	return 0;
}

void cal(BYTE m,BYTE n , int i, int j)
{
	int length = j - i +1;
	m = m << i;
	BYTE filter = ~(((1<<length)-1)<<i) ;
	BYTE result = n&filter^m;
	cout<<result;


}
