/**
 * This is for the CCI book's question charpter 3.3
 * x.z.liang
 **/

#ifndef SETOFSTACK
#define SETOFSTACK

template <class T>
class SetOfStack
{

	public:

		T pop();		
		void push();
		T popAt(const int& index);		
	privated:	
		Stack<T> stacks;	

};


#endif
