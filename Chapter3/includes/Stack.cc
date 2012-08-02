#include"Stack.h"

template<class T>
bool Stack<T>::isEmpty()
{
	return head==0;
}

template<class T>
bool Stack<T>::isFull()
{
	try
	{
		StackNode<T> *p = new StackNode<T>();
		delete p;
		return false;
	}catch(const stack_is_full &e)
	{
		cerr<<e.what();
		return true;
	}
}

template<class T>
T Stack<T>::top() const
{
	if(isEmpty() == true)
	{
		throw try_to_access_empty_stack("Attemp to Access Empty Stack");
	}else
	{
		return head->data;
	}

}

template<class T>
void Stack<T>::pop()
{
	if(this->isEmpty() == true)
	{
		throw try_to_access_empty_stack("Attempt to Pop from Empty Stack");
	}else
	{
		StackNode<T>*p = head;
		head = head->next;
		delete p;
		p = 0;
	}
}

template<class T>
void Stack<T>::push(const T &v)
{
	StackNode<T> *p = new StackNode<T>();
	p->data = v;
	p->next = head;
	head = p;
}


