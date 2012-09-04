#include <iostream>

#define RIGHT 1
#define DOWN 0
using namespace std;

char* arrow[2] = {"Down","Right"};
int move_x[2] = {0,1};
int move_y[2] = {1,0};

class pos{
	public:
		pos(const int& s):size(s),x(0),y(0),step(0){
			path = new int[s+s-2];
			for(int i=0;i<s+s-2;i++){
				path[i] = -1;
			}
		}
		int *path;
		
		bool isEnd();
		bool isValid();
		pos move(const int& direction);
		void printPath();
		void printTest();	
		~pos(){
			delete []path;
			path = 0;
		}
		int step;
		int x;
		int y;
		int size;
};

void pos::printTest(){
	cout<<"x:"<<this->x<<" y:"<<this->y<<" step:"<<this->step<<" ";
}

pos pos::move(const int& direction){
	pos temp(this->size);
	temp.x = this->x + move_x[direction];
	temp.y = this->y + move_y[direction];
	temp.step = this->step+1;
	for(int i=0;i<this->step;i++){
		temp.path[i] = this->path[i];
	}
	temp.path[this->step] = direction;
	return temp;
}



bool pos::isValid()
{
	if(x >= size || y >= size){
		return false;
	}else{
		return true;
	}
}

bool pos::isEnd(){
	if(x == size-1 && y == size-1){
		return true;
	}else{
		return false;
	}
}

void pos::printPath(){
	for(int i=0;i<this->step;i++){
		cout<<arrow[this->path[i]]<<" ";
	}
	cout<<endl;
}

void findPath(const int & size, pos& p);

int main(){
	int n;
	while(cin>>n)
	{
		if(n == 0)
		{	
			break;
		}else{
			pos root(n);
			findPath(n,root);
		}
	}
	return 0;
}


void findPath(const int & size, pos& p){
	int n;
	if(p.isEnd() == true){
		p.printPath();
	}else{

		pos temp = p.move(RIGHT);
		if(temp.isValid() == true){
			findPath(size,temp);
		}

		pos temp2 = p.move(DOWN);
		if(temp2.isValid() == true){
			findPath(size,temp2);
		}
	}

}

