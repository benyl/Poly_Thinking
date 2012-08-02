#include<iostream>
#include<string.h>
using namespace std;
#ifndef STACK_IS_FULL
#define STACK_IS_FULL
class stack_is_full:public bad_alloc
{
	public:

		explicit stack_is_full():
							bad_alloc(){}
};
#endif
#ifndef TRY_TO_ACCESS_EMPTY_STACK
#define TRY_TO_ACCESS_EMPTY_STACK

class try_to_access_empty_stack:public exception
{
	public:

		explicit try_to_access_empty_stack():
										exception(){}

		virtual ~try_to_access_empty_stack() throw(){}
};
#endif
