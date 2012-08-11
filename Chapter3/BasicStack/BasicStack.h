//
//  BasicStack.h
//  BasicStack
//
//  Created by Xinzhao Liang on 8/5/12.
//

#ifndef BasicStack_h
#define BasicStack_h

 
  template<class T>
 class BasicStack
{
    public:
    
        BasicStack(){head = 0;}
    
        bool isEmpty();    
    
    private:
    
         T *head;
};

#endif
