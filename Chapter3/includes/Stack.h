#ifndef STACK
#define STACK
#include "StackExcept.h"
template<class T> 
class Stack;


template <class T>
class StackNode
{
	friend class Stack<T>;
	private:
		T data;
		T* next;
};

template <class T>
class Stack
{
	public:
		Stack(){head = 0;}
		~Stack();
		bool isEmpty();
		bool isFull();
		//only return the top of the stack, should not change any member data
		T top() const;
		void pop();
		void push(const T& StackNode);


	private:
		StackNode<T> *head;
};



#endif
