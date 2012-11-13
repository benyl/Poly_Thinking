#include<iostream>
#include<string.h>

using namespace std;

void trans(const string& decimal);

int main()
{
	string temp;
	while(cin>>temp)
	{
		trans(temp);	
		if(temp == "0"){
			break;
		}
	}
	return 0;
}

void trans(const string& decimal)
{
	int dot_pos = decimal.rfind('.');
	string str_int_part = decimal.substr(0,dot_pos);
	int int_part = atoi(str_int_part.c_str());	
	double dec_part = atof(decimal.c_str()) - int_part;
	
	
	// int part
	string int_result = "";
	while(int_part > 0){
		if(int_part % 2 == 0){
			int_result = "0" + int_result;
		}else{
			int_result = "1" + int_result;
		}
		int_part >>= 1;
	}

	//dec part
	string dec_result = "";
	while(dec_part>0){
		if(dec_result.size() > 32) {
			cout<<"ERROR"<<endl;// ERROR & BREAK 
			return;
		}
		double r = dec_part * 2.0;
		if( r >= 1.0){
			dec_result += "1";
			dec_part -= r - 1.0;
		}else{
			dec_result += "0";
			dec_part = r;
		}
	
	}
	cout<<int_result<<"."<<dec_result<<endl;
}


